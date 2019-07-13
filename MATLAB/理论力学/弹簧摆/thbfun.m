function F=thbfun(t,u,flag,l,k,m,g)
F=[u(2);
    u(1)*u(4)^2+g*cos(u(3))-k/m*(u(1)-1+m*g/k);
    u(4);
    -2*u(2)*u(4)/u(1)-g*sin(u(3))/u(1)];
end