clear;clc
syms x
y=1;
for t=1:500
    a=1-(x^2/(t^2*pi^2));
    y=y*a;
end
y=x*y;
ezplot(x,y,[-4*pi,4*pi])