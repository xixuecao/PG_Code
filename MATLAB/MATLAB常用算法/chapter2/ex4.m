% 常用的符号运算

%% 微分函数diff
clear;clc;
syms a x
f=sin(a*x)
dfx=diff(f,x)
dfa=diff(f,a)

%% 积分函数 int(integral)
clear;clc;
syms x
f=x*log(1+x)
int1=int(f,x)
int2=int(f,x,0,1)
