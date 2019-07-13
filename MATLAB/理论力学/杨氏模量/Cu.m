clear;clc;
m=38.06e-3;
f=719.9;
L=0.1595;
d=[5.472e-3 5.483e-3 5.481e-3 5.473e-3 5.474e-3];
averaged=mean(d)
%% d的不确定度............
D=sum((d-averaged).^2);
Ua=sqrt(D/4)
%% ......................
Y=1.6067*L^3*m*f^2/averaged^4
RelativeY=Y*sqrt((4*5.0299e-6/averaged)^2+(2*0.1/f)^2)
Ycumax=Y+RelativeY;
Ycumin=Y-RelativeY