%  Illustrating the Use of meshgrid
clear;clc;
[X,Y]=meshgrid(-8:.5:8);
R=sqrt(X.^2+Y.^2)+eps;
Z=sin(R)./R;
figure
mesh(X,Y,Z)
hidden off  % Hidden Line Removal

figure
colormap hsv
surf(X,Y,Z,'FaceColor','interp',...
'EdgeColor','none',...
'FaceLighting','gouraud')
daspect([5 5 1])
axis tight
view(-50,30)
camlight left