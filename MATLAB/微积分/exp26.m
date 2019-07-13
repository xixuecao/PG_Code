%求解微分方程组2.2
syms x(t) y(t)
A=[1 2;-1 1];
B=[1;t];
Y=[x;y];
S=dsolve(diff(Y)==A*Y+B);
x=simplify(S.x)
y=simplify(S.y)