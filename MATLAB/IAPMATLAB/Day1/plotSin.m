function plotSin(f1,f2)
x=linspace(0,2*pi,f1*16+1);
    figure
if nargin==1
    plot(x,sin(f1*x),'rs--',...
        'LineWidth',2,'MarkerFaceColor','k');
elseif nargin==2
    disp('Two inputs were given')
    y=linspace(0,2*pi,f2*16+1);
    [X,Y]=meshgrid(x,y);
    Z=sin(f1*X)+sin(f2*Y);
    subplot(211);
    imagesc(x,y,Z);colorbar;colormap hot;axis xy;
    subplot(212);
    surf(X,Y,Z)
end
end



