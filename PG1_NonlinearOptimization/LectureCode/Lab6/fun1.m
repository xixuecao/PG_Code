function y = fun1(x)
n = length(x);
y = 0;
for i = 1:n-1
    y = y + (1-x(i))^2 + 100*(x(i+1) - x(i)^2)^2;
end

