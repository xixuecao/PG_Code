clear;clc
syms x y
f = (1 - x)^2+100*(y - x^2)^2;
[x,k] = grad(f,-2,2)
