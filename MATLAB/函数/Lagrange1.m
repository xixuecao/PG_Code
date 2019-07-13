clear;clc;
global l R g w ;
l=0.534;R=0.15;g=9.8;w=5*pi;
tspan=[0 180];
IC=[0.02 0 pi 0];
options = odeset('RelTol',1e-4,'AbsTol',[1e-4 1e-4 1e-5 1e-4]);
[T,X] = ode23(@lanrange2,tspan,IC,options);
plot(T,X(:,1),'-',T,X(:,3),'r')
legend('r','½Ç¶È')
grid on


