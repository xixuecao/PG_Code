%求解微分方程3
syms y(t)
y(t)=dsolve(diff(y,t)==t*y,y(0)==2)
