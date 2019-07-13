% a*x^3 + b/(x^0.5)+ c*x^2 + d = 0
clear;clc;
syms x
a=1;b=2;c=1;
ans=[];
for d=1:5
    ans=[ans vpasolve(a*x^3 + b/(x^0.5)+ c*x^2 + d,x)];
end
ans