clear;clc
% n=2;
% N=50; % 20, 50, 100
% X=lhsamp(N,n); % generate samples
fi = @(r) exp(-r.^2);
x = 1:0.1:5;
f = @(x) exp(-x/2).*sin(2*x);
plot(x,f(x))
% pdist(dots)
