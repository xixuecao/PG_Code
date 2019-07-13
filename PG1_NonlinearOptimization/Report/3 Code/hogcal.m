% 这个函数借鉴matlab自带function修改而成

function F = hogcal(img)

cellpw = 8;
cellph = 8;
nblockw = 2;
nblockh = 2;
nthet = 9;
overlap = 0.5;


[M, N, K] = size(img);

% set the standard deviation of gaussian spatial weight window.
delta = cellpw*nblockw * 0.5;

% calculate gradient scale matrix.
hx = [-1,0,1];
hy = -hx';
gradscalx = imfilter(double(img),hx);
gradscaly = imfilter(double(img),hy);

% 
if K > 1
        maxgrad = sqrt(double(gradscalx.*gradscalx + gradscaly.*gradscaly));
        [gradscal, gidx] = max(maxgrad,[],3);
        gxtemp = zeros(M,N);
        gytemp = gxtemp;
        for kn = 1:K
            ttempx = gradscalx(:,:,kn);
            ttempy = gradscaly(:,:,kn);
            tmpindex = find(gidx==kn);
            gxtemp(tmpindex) = ttempx(tmpindex);
            gytemp(tmpindex) =ttempy(tmpindex);
        end
        gradscalx = gxtemp;
        gradscaly = gytemp;
else
    gradscal = sqrt(double(gradscalx.*gradscalx + gradscaly.*gradscaly));
end

% calculate gradient orientation matrix.
% plus small number for avoiding dividing zero.
gradscalxplus = gradscalx+ones(size(gradscalx))*0.0001;

% unsigned: orientation region is 0 to pi.
gradorient = atan(gradscaly./gradscalxplus);
gradorient(gradorient<0) = gradorient(gradorient<0)+pi;
or = 1;

% calculate block slide step.
xbstride = cellpw*nblockw*(1-overlap);
ybstride = cellph*nblockh*(1-overlap);
xbstridend = N - cellpw*nblockw + 1;
ybstridend = M - cellph*nblockh + 1;

% calculate the total blocks number in the window detected, which is
% ntotalbh*ntotalbw.
ntotalbh = ((M-cellph*nblockh)/ybstride)+1;
ntotalbw = ((N-cellpw*nblockw)/xbstride)+1;


hist3dbig = zeros(nblockh+2, nblockw+2, nthet+2);
F = zeros(1, ntotalbh*ntotalbw*nblockw*nblockh*nthet);
% generate the matrix for storing histogram of one block;
sF = zeros(1, nblockw*nblockh*nthet);

% generate gaussian spatial weight.
[gaussx, gaussy] = meshgrid(0:(cellpw*nblockw-1), 0:(cellph*nblockh-1));
weight = exp(-((gaussx-(cellpw*nblockw-1)/2).*(gaussx-(cellpw*nblockw-1)/2)+(gaussy-(cellph*nblockh-1)/2)...
    .*(gaussy-(cellph*nblockh-1)/2))/(delta*delta));

xbstep = xbstride;
ybstep = ybstride;

% block slide loop
for btly = 1:ybstep:ybstridend
    for btlx = 1:xbstep:xbstridend
        for bi = 1:(cellph*nblockh)
            for bj = 1:(cellpw*nblockw)
                
                i = btly + bi - 1;
                j = btlx + bj - 1;
                gaussweight = weight(bi,bj);
                
                gs = gradscal(i,j);
                go = gradorient(i,j);
                jorbj = bj;
                iorbi = bi; 
                % calculate bin index of hist3dbig
                binx1 = floor((jorbj-1+cellpw/2)/cellpw) + 1;
                biny1 = floor((iorbi-1+cellph/2)/cellph) + 1;
                binz1 = floor((go+(or*pi/nthet)/2)/(or*pi/nthet)) + 1;
                
                if gs < 1E-5
                    continue;
                end
                
                binx2 = binx1 + 1;
                biny2 = biny1 + 1;
                binz2 = binz1 + 1;
                
                x1 = (binx1-1.5)*cellpw + 0.5;
                y1 = (biny1-1.5)*cellph + 0.5;
                z1 = (binz1-1.5)*(or*pi/nthet);
                
                % trilinear interpolation.
                hist3dbig(biny1,binx1,binz1) =...
                    hist3dbig(biny1,binx1,binz1) + gs*gaussweight...
                    * (1-(jorbj-x1)/cellpw)*(1-(iorbi-y1)/cellph)...
                    *(1-(go-z1)/(or*pi/nthet));
                hist3dbig(biny1,binx1,binz2) =...
                    hist3dbig(biny1,binx1,binz2) + gs*gaussweight...
                    * (1-(jorbj-x1)/cellpw)*(1-(iorbi-y1)/cellph)...
                    *((go-z1)/(or*pi/nthet));
                hist3dbig(biny2,binx1,binz1) =...
                    hist3dbig(biny2,binx1,binz1) + gs*gaussweight...
                    * (1-(jorbj-x1)/cellpw)*((iorbi-y1)/cellph)...
                    *(1-(go-z1)/(or*pi/nthet));
                hist3dbig(biny2,binx1,binz2) =...
                    hist3dbig(biny2,binx1,binz2) + gs*gaussweight...
                    * (1-(jorbj-x1)/cellpw)*((iorbi-y1)/cellph)...
                    *((go-z1)/(or*pi/nthet));
                hist3dbig(biny1,binx2,binz1) =...
                    hist3dbig(biny1,binx2,binz1) + gs*gaussweight...
                    * ((jorbj-x1)/cellpw)*(1-(iorbi-y1)/cellph)...
                    *(1-(go-z1)/(or*pi/nthet));
                hist3dbig(biny1,binx2,binz2) =...
                    hist3dbig(biny1,binx2,binz2) + gs*gaussweight...
                    * ((jorbj-x1)/cellpw)*(1-(iorbi-y1)/cellph)...
                    *((go-z1)/(or*pi/nthet));
                hist3dbig(biny2,binx2,binz1) =...
                    hist3dbig(biny2,binx2,binz1) + gs*gaussweight...
                    * ((jorbj-x1)/cellpw)*((iorbi-y1)/cellph)...
                    *(1-(go-z1)/(or*pi/nthet));
                hist3dbig(biny2,binx2,binz2) =...
                    hist3dbig(biny2,binx2,binz2) + gs*gaussweight...
                    * ((jorbj-x1)/cellpw)*((iorbi-y1)/cellph)...
                    *((go-z1)/(or*pi/nthet));
            end
        end
        
        % In the local interpolate condition. F is generated in this block 
        % slide loop. hist3dbig should be cleared in each loop.
        hist3dbig(:,:,2) = hist3dbig(:,:,2) + hist3dbig(:,:,nthet+2);
        hist3dbig(:,:,(nthet+1)) = hist3dbig(:,:,(nthet+1)) + hist3dbig(:,:,1);
        hist3d = hist3dbig(2:(nblockh+1), 2:(nblockw+1), 2:(nthet+1));
        for ibin = 1:nblockh
            for jbin = 1:nblockw
                idsF = nthet*((ibin-1)*nblockw+jbin-1)+1;
                idsF = idsF:(idsF+nthet-1);
                sF(idsF) = hist3d(ibin,jbin,:);
            end
        end
        iblock = ((btly-1)/ybstride)*ntotalbw +...
            ((btlx-1)/xbstride) + 1;
        idF = (iblock-1)*nblockw*nblockh*nthet+1;
        idF = idF:(idF+nblockw*nblockh*nthet-1);
        F(idF) = sF;
        hist3dbig(:,:,:) = 0;
    end
end
F(F<0) = 0;

% block normalization.
e = 0.001;
l2hysthreshold = 0.2;
fslidestep = nblockw*nblockh*nthet;

for fi = 1:fslidestep:size(F,2)
    sF = F(fi:(fi+fslidestep-1)).*F(fi:(fi+fslidestep-1));
    div = sqrt(sum(sF)+e*e);
    sF = F(fi:(fi+fslidestep-1))/div;
    sF(sF>l2hysthreshold) = l2hysthreshold;
    div = sqrt(sum(sF.*sF)+e*e);
    F(fi:(fi+fslidestep-1)) = sF/div;
end
