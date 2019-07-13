clc
clear all
global a1 a2 ch kn omega phi;
a1=1; a2=1; ch=1; kn=1; omega=1; phi=pi/4;
tspan=[0 100];
IC=[0 1];
[T,X] = ode45(@caimeiji,tspan,IC)
plot(T,X(:,1),'-',T,X(:,2),'-.')