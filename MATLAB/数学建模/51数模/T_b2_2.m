%��ֵ
clear;
clc;
A=[];
b=[];
Aeq =[3586483 1829214 2392866 6727716 17201878];
beq = 1586907;
f =@(x)abs(1499149894*x(1)+116447763*x(2)+74274561*x(3)+48708664*x(4)+23738592*x(5));
lu=[-1 -1 -1 -1 -1];
bu=[1 1 1 1 1];
x0=[0 0 0 0 0.01];
[x,fval]= fmincon(f,x0,A,b,Aeq,beq,lu,bu)