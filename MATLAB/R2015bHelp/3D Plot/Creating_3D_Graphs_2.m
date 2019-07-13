% Displaying Nonuniform Data on a Surface
clear;clc;
x=rand(100,1)*16-8;
y=rand(100,1)*16-8;
r=sqrt(x.^2+y.^2)+eps;
z=sin(r)./r;

xlin=linspace(min(x),max(x),33);
ylin=linspace(min(y),max(y),33);

[X,Y]=meshgrid(xlin,ylin);
%% ans1
f = scatteredInterpolant(x,y,z);
Z=f(X,Y);

figure
mesh(X,Y,Z) %interpolated
axis tight; hold on
plot3(x,y,z,'.','MarkerSize',15) %nonuniform
%% 
R=sqrt(X.^2+Y.^2)+eps;
Z=sin(R)./R;

figure
mesh(X,Y,Z) %interpolated
axis tight; hold on
plot3(x,y,z,'.','MarkerSize',15) %nonuniform