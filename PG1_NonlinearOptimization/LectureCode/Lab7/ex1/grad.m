function [xout,k] = grad(f,lb,ub)
g=matlabFunction(gradient(f));
x = lb:.01:ub;
y = lb:.01:ub;
index = randi(length(x));
x_best = x(index);
y_best = y(index);
a = x_best ;
b = y_best;
u = [a b]';
h = 0.001;
m = -2;
n = 0;
k = 0;
while  abs(m) > 1.0e-5 || abs(n) > 1.0e-5
    A = [m n]';
    u = u - h*A;
    if ismember(1,u<lb) || ismember(1,u>ub)
        break;
    end
    a = u(1);
    b = u(2);
    S = g(a,b);
    m = S(1);
    n = S(2);
    k = k + 1;
end
xout = u;
end

