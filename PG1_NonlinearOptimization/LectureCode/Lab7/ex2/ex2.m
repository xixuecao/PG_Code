clear;clc;
f = @(x,y) (1-x).^2 + 100*(y - x.^2).^2;
lb = -2;ub = 2;
[x,y,f,k]=rsa(f,lb,ub)
