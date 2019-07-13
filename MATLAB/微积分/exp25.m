%求解微分方程组2.1
syms x(t) y(t)
z=dsolve('Dx=x+2*y+1','Dy=-x+y+t')
x=simplify(z.x)
y=simplify(z.y)