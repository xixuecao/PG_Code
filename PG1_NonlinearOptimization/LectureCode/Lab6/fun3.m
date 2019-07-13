function y = fun3(x,t,Y)

y = x(1).*exp(-x(2).*t) + x(3).*exp(-x(4).*t) - Y;
end

