clear;clc
syms x
x1 = 5;
f1 = x^2;
fplot(f1,[0 x1])
set(gca,'position',[0.1300 0.300 0.7750 0.5])
grid on
hold on
x1 = vpa(Newtons_Method(f1,x1))


