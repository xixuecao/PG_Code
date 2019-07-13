b=0:0.01:3;
c=1;
c1=0.2;
c2=0.3;
c3=0.4;
y=atan(2*c*b/(1-b.^2));
plot(b,atan(2*c*b./(1-power(b,2))))
axis([0 3 -pi/2,pi/2])
hold on
plot(b,atan(2*c1*b./(1-power(b,2))),'b')
hold on
plot(b,atan(2*c2*b./(1-power(b,2))),'r')
hold on
plot(b,atan(2*c3*b./(1-power(b,2))),'m')