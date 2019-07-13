clear;clc
f = @(x) (1-x(1)).^2 + 100*(x(2) - x(1).^2).^2;
dea(f)