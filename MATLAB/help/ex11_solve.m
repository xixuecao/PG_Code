clear;clc;
b=0.009;ea=0.02;
x=0.001;y=0.002;z=0;p=0;o=0;f=0;
Qe=[x;y;z];
z1=[1 0 0;0 cos(p) sin(p);0 -sin(p) cos(p)];
z2=[cos(o) 0 -sin(o);0 1 0;sin(o) 0 cos(o)];
z3=[cos(f) sin(f) 0;-sin(f) cos(f) 0;0 0 1];
olz=z3*z2*z1;
[sita1 ysita1] = jidian(Qe,olz,b,ea)
