syms x(t) y(t) z(t) R l w g

z = sqrt(-R^2-x^2+2*x*R*cos(y)+l^2);
dzdt=diff(z)
L=1/2*diff(x)^2+1/2*x^2*(w-diff(y))^2+1/2*diff(z)^2+g*z

