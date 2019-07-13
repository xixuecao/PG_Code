theta0=pi/2;
m=1.1;k=80;g=9.8;
l0=1;
l=l0+m*g/k;
[t,u1]=ode45('thbfun',[0:0.005:50],[l0 0 theta0 0],[],l,k,m,g);
[y1,x1]=pol2cart(u1(:,3),u1(:,1));
y1=-y1;
 
figure
ymax=max(abs(y1));
axis([-1.2 1.2 -1.2*ymax 0.2]);
axis off
hold on;
R=0.055;
yy=-l0:0.01:0;
xx=R*sin(yy./l0*30*pi);
[a,r]=cart2pol(xx,yy);
a=a+theta0;
[xx,yy]=pol2cart(a,r);
line([-0.5 0.5],[0 0],'color','r','linewidth',2)
ball=line(xx(1),yy(1),'color','r','marker','.','markersize',70,'erasemode','xor');
ball2=line(xx(1),yy(1),'color',[0.5 0.51 0.6],'linestyle','-','linewidth',1.3,'erasemode','none');
spring=line(xx,yy,'color','g','linewidth',2,'erasemode','xor');
 
pause(0.5);
 
for i=1:length(t)
    yy=-u1(i,1):0.01:0;
    xx=R*sin(yy./u1(i,1)*30*pi);
    [a,r]=cart2pol(xx,yy);
    a=a+u1(i,3);
    [xx,yy]=pol2cart(a,r);
    set(ball,'XData',x1(i),'YData',y1(i));
    set(ball2,'XData',x1(i),'YData',y1(i));
    set(spring,'XData',xx,'YData',yy);
    drawnow;
end
huitu(50,t,u1,0.005);