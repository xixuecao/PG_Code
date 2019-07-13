clear;clc;
m=35.39e-3;
f=1029;
L=15.95e-2;
d=[5.465e-3 5.472e-3 5.472e-3 5.472e-3 5.475e-3];
averaged=mean(d)
%% d的不确定度............
D=sum((d-averaged).^2);
Ua=sqrt(D/4)
%% .....................
Y=1.6067*L^3*m*f^2/averaged^4
RelativeY=Y*sqrt((4*5e-6/averaged)^2+(2*1/f)^2)
Ycumax=Y+RelativeY;
Ycumin=Y-RelativeY;