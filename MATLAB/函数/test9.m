syms x y X Y m l R g w t
L=(x^2*(w - Y)^2)/2 + X^2/2 - (2*x*X - 2*R*cos(y)*X + 2*R*sin(y)*x*Y)^2/(8*(x^2 + R^2 - l^2 - 2*R*cos(y)*x)) + g*(l^2 - R^2 - x^2 + 2*R*cos(y)*x)^(1/2);
dLdX=simplify(diff(L,X))
dLdx=simplify(diff(L,x))

dLdY=simplify(diff(L,Y))
dLdy=simplify(diff(L,y))


