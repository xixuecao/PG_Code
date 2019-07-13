function huitu(tmax,t,y,step);
subplot(3,2,1);
plot(t,y(:,1));
subplot(3,2,2);
plot(t,y(:,2));
subplot(3,2,3);
plot(t,y(:,3));
subplot(3,2,4);
plot(t,y(:,4));
 
a=diff(y(:,3))/step;
subplot(3,2,5);
plot(0:step:tmax-step,a);
 
w=diff(y(:,4))/step;
subplot(3,2,6);
plot(0:step:tmax-step,w);