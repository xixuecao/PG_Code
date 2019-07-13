function [t,w,z]=brwnm2()
t0 = 0;
tf = 10;
h = 0.01;
t=t0:h:tf;
x=randn(size(t))*sqrt(h);
y=randn(size(t))*sqrt(h);
w(1)=0;
z(1)=0;
  for k=1:length(t)-1
      w(k+1)=w(k)+x(k);
      z(k+1)=z(k)+y(k);
  end
  plot(w,z);
