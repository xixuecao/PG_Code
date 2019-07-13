%求解微分方程组1
syms x(t) y(t)
%[x,y]=dsolve(diff(x)==y,diff(y)==-x)
%[x,y]=dsolve('Dx=y','Dy=-x')
z=dsolve('Dx=y','Dy=-x')
x=z.x
y=z.y