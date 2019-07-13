function F=fun(t)
syms k
f1=t(1)-((k-1)+(2-k)*erf(log(t(2))+0.5))/(1+(k-2)*erf(log(t(2))-0.5));
f2=t(2)-((k-1)+(2-k)*erf(log(t(1))+0.5))/(1+(k-2)*erf(log(t(1))-0.5));
F=[f1;f2];
end

