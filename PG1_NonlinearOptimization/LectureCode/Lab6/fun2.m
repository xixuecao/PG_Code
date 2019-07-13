function y = fun2(x)
n = length(x);
temp = 0;
for i = 1:n
    temp = temp + x(i)/i;
end
y = exp(temp);
end

