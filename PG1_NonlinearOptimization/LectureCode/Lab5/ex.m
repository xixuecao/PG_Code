clear;clc
xinit = [0 0];
lb = -0.5;ub = 1.5;
f = @(x,y) (1-x).^2 + 5*(x - y.^2).^2;
% lb = -2;ub = 8;
% f = @(x,y) 2*x.^2 + 3*y.^2 - 3*x.*y + x;
x = linspace(lb,ub,201);
y = x;
[X,Y] = meshgrid(x,y);
Z = f(X,Y);
contour(X,Y,Z);
hold on
grid on
l = 0.1;
flag = true;
while flag
    if xinit <= ub & xinit >= lb
        [xinit,l,flag] = fcross(xinit,l,f);
    else
        break;
    end
    
end
% xinit
disp(['模式搜索最小值:',num2str(min(f(xinit(1),xinit(2))))])
disp(['函数在范围内最小值:',num2str(min(f(x,y)))])
% patternsearch