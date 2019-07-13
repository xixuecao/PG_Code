clear;clc;
x=130:400;y=-120:150;
[X,Y]=meshgrid(x,y);
a1=0.9243;y1=0.1772;
a2=0.9176;y2=0.1068;
s=72;%泄漏速率
t=60;

H=8;%泄漏高度
u=3;%泄漏点风速
G=s*t;%泄漏总质量
SY=y1*(X.*abs(X).^(a1-1));%扩散系数
SZ=y2*(Y.*abs(Y).^(a2-1));
SX=SY;
z=1;

c=((2*G)/((2*pi)^3/2)*SX.*SY.*SZ).*exp(-((X-u*t).^2)./(2*SX.^2)-(Y.^2)./(2*SY.^2))...
    .*(exp(-((z-H)^2)./(2*SZ.^2))+exp(-((z+H)^2)./(2*SZ.^2)));
mesh(X,Y,c)
hold on
contour3(X,Y,c,15)
%% 
x=130:400;y=-120:150;c=0:300;
[X,Y,C]=meshgrid(x,y,c);
SY=y1*(X.*abs(X).^(a1-1));%扩散系数
SZ=y2*(Y.*abs(Y).^(a2-1));
SX=SY;
fv=((2*G)/((2*pi)^3/2)*SX.*SY.*SZ).*exp(-((X-u*t).^2)./(2*SX.^2)-(Y.^2)./(2*SY.^2))...
    .*(exp(-((z-H)^2)./(2*SZ.^2))+exp(-((z+H)^2)./(2*SZ.^2)))-C;
figure
contourslice(X,Y,C,fv,[],[],1,[0 0])
hold on
contourslice(X,Y,C,fv,[],[],31,[0 0])
contourslice(X,Y,C,fv,[],[],99,[0 0])
% Z=ones(271);
% surf(X,Y,Z)
