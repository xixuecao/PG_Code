syms x y X Y m l R g w A B
dLdx =x*(Y - w)^2 - (g*(x - R*cos(y)))/(- R^2 + 2*cos(y)*R*x + l^2 - x^2)^(1/2) - ((2*X + 2*R*Y*sin(y))*(2*X*x - 2*R*X*cos(y) + 2*R*Y*x*sin(y)))/(4*(R^2 - 2*cos(y)*R*x - l^2 + x^2)) + ((16*x - 16*R*cos(y))*(X*x - R*X*cos(y) + R*Y*x*sin(y))^2)/(16*(R^2 - 2*cos(y)*R*x - l^2 + x^2)^2);

dLdy =(R*x*sin(y)*(X*x - R*X*cos(y) + R*Y*x*sin(y))^2)/(R^2 - 2*cos(y)*R*x - l^2 + x^2)^2 - (R*g*x*sin(y))/(- R^2 + 2*cos(y)*R*x + l^2 - x^2)^(1/2) - (R*(X*sin(y) + Y*x*cos(y))*(2*X*x - 2*R*X*cos(y) + 2*R*Y*x*sin(y)))/(2*(R^2 - 2*cos(y)*R*x - l^2 + x^2));

LXt =A - ((4*X + 4*R*sin(y)*Y)*(2*X*x - 2*R*cos(y)*X + 2*R*sin(y)*Y*x))/(8*x^2 + 8*R^2 - 8*l^2 - 16*R*cos(y)*x) - ((4*x - 4*R*cos(y))*(2*X*X + 2*x*A - 2*R*cos(y)*A + 2*R*sin(y)*X*Y + 2*R*sin(y)*Y*X + 2*R*sin(y)*x*B + 2*R*cos(y)*Y*x*Y))/(8*x^2 + 8*R^2 - 8*l^2 - 16*R*cos(y)*x) + ((4*x - 4*R*cos(y))*(2*X*x - 2*R*cos(y)*X + 2*R*sin(y)*Y*x)*(16*x*X - 16*R*cos(y)*X + 16*R*sin(y)*x*Y))/(8*R^2 - 16*cos(y)*R*x - 8*l^2 + 8*x^2)^2;

LYt =x^2*B - 2*x*(w - Y)*X - (R*sin(y)*X*(2*X*x - 2*R*cos(y)*X + 2*R*sin(y)*Y*x))/(2*x^2 + 2*R^2 - 2*l^2 - 4*R*cos(y)*x) - (R*sin(y)*x*(2*X*X + 2*x*A - 2*R*cos(y)*A + 2*R*sin(y)*X*Y + 2*R*sin(y)*Y*X + 2*R*sin(y)*x*B + 2*R*cos(y)*Y*x*Y))/(2*x^2 + 2*R^2 - 2*l^2 - 4*R*cos(y)*x) - (R*cos(y)*x*Y*(2*X*x - 2*R*cos(y)*X + 2*R*sin(y)*Y*x))/(2*x^2 + 2*R^2 - 2*l^2 - 4*R*cos(y)*x) + (R*sin(y)*x*(2*X*x - 2*R*cos(y)*X + 2*R*sin(y)*Y*x)*(4*x*X - 4*R*cos(y)*X + 4*R*sin(y)*x*Y))/(2*R^2 - 4*cos(y)*R*x - 2*l^2 + 2*x^2)^2;
f1=LXt-dLdx
f2=LYt-dLdy


