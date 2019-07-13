%求解微分方程4
syms x y
y=dsolve('D2y-Dy/x-x*exp(x)','x')
simplify(y)