%求解微分方程1
syms y(t)
y(t)=dsolve(diff(y,t)==t*y)
