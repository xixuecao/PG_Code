clear;clc;
m=0.0379;
f=688.9;
L=0.1595;
d=[5.455e-3 5.469e-3 5.465e-3 5.478e-3 5.459e-3];
averaged=mean(d)
%% d的不确定度............
D=sum((d-averaged).^2);
Ua=sqrt(D/4)
%% ......................
Y=1.6067*L^3*m*f^2/averaged^4
RelativeY=Y*sqrt((4*9e-6/averaged)^2+(2*0.1/f)^2)
Ycumax=Y+RelativeY;
Ycumin=Y-RelativeY;