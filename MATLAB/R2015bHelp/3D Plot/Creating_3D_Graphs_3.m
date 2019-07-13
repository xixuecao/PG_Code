% Parametric Surfaces
clear;clc;
figure;
k=5;
n=2^k-1;
theta=pi*(-n:2:n)/n;
phi=(pi/2)*(-n:2:n)'/n;
X=cos(phi)*cos(theta);
Y=cos(phi)*sin(theta);
Z=sin(phi)*ones(size(theta));
colormap([0 0 0;0.3 1 1]);
C=hadamard(2^k);
surf(X,Y,Z,C);
axis square
