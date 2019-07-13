clc;clear;
[Ubm,Rc]=meshgrid([1/2:0.1:50],[-50:0.1:50]);
Ucm=(9/pi)*Ubm.*Rc.*(acos(1-1./Ubm)-1/2*sin(2*acos(1-1./Ubm)));
mesh(Ubm,Rc,Ucm)
