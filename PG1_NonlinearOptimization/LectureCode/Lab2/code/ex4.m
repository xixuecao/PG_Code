clear;clc;
f = @(t,y) -y + 3*cos(3*t)*exp(-t);
y = @(t) sin(3*t).*exp(-t);
y0 = 0;
h = 0.1;
Numerical_Methods(f,y,y0,h)