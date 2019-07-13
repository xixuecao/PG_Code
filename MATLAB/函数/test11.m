syms x(t) y(t) X(t) Y(t) m l R g w
LX =X - (2*(2*x - 2*R*cos(y))*(2*X*x - 2*R*X*cos(y) + 2*R*Y*x*sin(y)))/(8*R^2 - 16*cos(y)*R*x - 8*l^2 + 8*x^2);
LY =x^2*(Y - w) - (R*x*sin(y)*(2*X*x - 2*R*X*cos(y) + 2*R*Y*x*sin(y)))/(2*(R^2 - 2*cos(y)*R*x - l^2 + x^2));
LXt=diff(LX,t)
LYt=diff(LY,t)

