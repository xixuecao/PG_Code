%���΢�ַ���4
syms x y
y=dsolve('D2y-Dy/x-x*exp(x)','x')
simplify(y)