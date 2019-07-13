clear;clc;
Dr=1.1;
Dd=1.2;
D0=1;
Hr=1.1;
Hd=1.;
Qgr=1;
syms x y;
Ar=pi*(Dr^2-D0^2)/4;
Ad=pi*(Dd^2-Dr^2)/4;
AEx=(Hr-Hd)*Dd*pi;
Rer=y*(Dr-D0)/(1-x*0.8937);
Fr=y/(9.8*(Dr-D0))^0.5;
KT=5.1*100000000*((1-Ar/Ad)^2)*Rer^-1.79;
KW=(1.45*Hr*x*(1-x)^2)/((Dr-D0)*Fr^2);

Ugr=Qgr/Ar;
Vb=Ugr/x-y/(1-x);

F(1)=Qgr/Ar-Vb*x-x*y/(1-x);
F(2)=19.6*Hr*x-0.0116*((1-x)^0.2)*y*(y+(Qgr/Ar))*Hr/...
    ((Dr-D0)^1.2)-0.0116*((Ar/Ad)^1.8)*(y^1.8)*Hd/((Dd-Dr)^1.2)-....
    (KT*(1-x^(-2))+KW*(1-x^(-2))+1.4+1.5*(Ar/AEx)^2)*(y^2);
F1=matlabFunction(F(1));
F2=matlabFunction(F(2));
f=@(x)[F1(x(1),x(2)),F2(x(1),x(2))];
% fplot(f)
% f=@(x) BQQ(Dr,Dd,D0,Hr,Hd,Qgr,x);
x=fsolve(f,[1 0.001]);