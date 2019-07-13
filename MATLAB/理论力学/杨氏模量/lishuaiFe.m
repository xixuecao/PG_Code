clear;clc;
m=0.03539;
f=1026;
L=0.1595;
d=[5.482e-3 5.490e-3 5.473e-3 5.478e-3 5.480e-3];
averaged=mean(d)
%% d的不确定度............
D=sum((d-averaged).^2);
Ua=sqrt(D/4)
%% ......................
Y=1.6067*L^3*m*f^2/averaged^4
RelativeY=Y*sqrt((4*6e-6/averaged)^2+(2*1/f)^2)
Ycumax=Y+RelativeY;
Ycumin=Y-RelativeY;