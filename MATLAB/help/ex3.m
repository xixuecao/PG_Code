clear;clc;
a=1;
f=@(x) myfun(a,x);
fsolve(f,[1,1])