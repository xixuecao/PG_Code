global a
a=1;
L0=1;
theta0=pi/6;
tmax=100;
step=0.01;
%%%%%%%%%%求解微分方程
[t,y]=ode45('fthbai',[0:step:tmax],[0,theta0,0,0]);
%%%%%%%%%%调用绘图子程序绘图
huitu(tmax,t,y,step);
 
%%%%%%%%%%坐标转换为实际坐标
y(:,1)=y(:,1)+ ones(size([0:step:tmax]),1);
[y1,x1]=pol2cart(y(:,2),y(:,1));
y1=-y1;
%%%%%%%%%%初始化动画界面
figure(2)
text(-0.2,0.1,'弹簧摆');
ymax=max(abs(y1));
xmax=max(abs(x1));
axis([-1*xmax xmax -1*ymax 0.2]);
axis equal
%%%%%%%%%%%画初始位置
R=0.05;
yy=-y(1,1):0.01:0;
xx=R*sin(yy./1*30*pi);
[a,r]=cart2pol(xx,yy);
a=a+theta0;
[xx,yy]=pol2cart(a,r);
line([-0.5 0.5],[0 0],'color','r','linewidth',2)
ball=line(xx(1),yy(1),'color','r','marker','.',...
    'markersize',70,'erasemode','xor');
ball2=line(xx(1),yy(1),'color',[0.5 0.51 0.6],...
  'linestyle','-','linewidth',1.3,'erasemode','none');
spring=line(xx,yy,'color','g','linewidth',2,'erasemode','xor');
pause(1.5);
%%%%%%%%%%做动画
for i=1:length(t)
    yy=-y(i,1):0.01:0;
    xx=R*sin(yy./y(i,1)*30*pi);
    [a,r]=cart2pol(xx,yy);
    a=a+y(i,2);
    [xx,yy]=pol2cart(a,r);
    set(ball,'XData',x1(i),'YData',y1(i));
    set(ball2,'XData',x1(i),'YData',y1(i),...
        'color',[i/length(t),i/length(t),1-i/length(t)]);
    set(spring,'XData',xx,'YData',yy);
    drawnow;
end