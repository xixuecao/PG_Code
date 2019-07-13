%% 画图
clear;clc;
syms x
y1=cos(x)*cosh(x);
y2=-1;
ezplot(y1,[-50,50]);
hold on
% line([-300,300],[-1,-1])
%% 解值1
clear;clc;
fun1=@(x) cos(x)*cosh(x)+1;
ans=arrayfun(@(x0) fsolve(fun1,x0),[-300:1:300])
%% 解值2
clear;clc;
syms x
fun2=cos(x)*cosh(x)+1;
ans=arrayfun(@(x0) vpasolve(fun2,x0),[-300:1:300])

