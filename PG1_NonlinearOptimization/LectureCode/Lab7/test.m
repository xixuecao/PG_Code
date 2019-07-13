clear;clc;
f = @(x,y) (1-x).^2 + 100*(y - x.^2).^2;
x = -2:.01:2;
y = -2:.01:2;
index = randi(length(x));
x_best = x(index);
y_best = y(index);
f_best = f(x_best,y_best);
syms x y
fun = (1 - x)^2+100*(y - x^2)^2;
gf = gradient(fun);
a = x_best ;
b = y_best;
u = [a b]';
h = 0.001;
m = -2;
n = 0;
while  abs(m) > 1.0e-5 || abs(n) > 1.0e-5
    A = [m n]';
    u = u - h*A;
    a = u(1);
    b = u(2);
    m = 2*(a - 1) + 400*(a^3 - a*b);
    n = 200*(b - a^2);
end

%最终求得的最小值点
u