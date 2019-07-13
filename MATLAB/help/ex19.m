%solve解方程组
clear;clc;
x=[1 2 3 4 5]';
y=[0 1 2 1 0]';
x2=x.^2;
y2=y.^2;
xy=x.*y;
C1=[x2,xy,y2,x,y];
C2=[-1 -1 -1 -1 -1 ]';
C = C1^-1*C2;
a=C(1,1);
b=C(2,1);
c=C(3,1);
syms  X2;
X2=solve((c/a-b^2/(4*a^2))*X2^2+1,X2)

