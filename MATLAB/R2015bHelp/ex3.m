clear;clc;
x=[1 2 3];
y=[2 4 6];

  t=polyfit(x,y,1)
  v=polyval(t,x)
  
plot(x,v)