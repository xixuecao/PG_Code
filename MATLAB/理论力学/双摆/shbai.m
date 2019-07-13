%%初始化参数
global m1 m2 l1 l2 g tao1 tao2
g=9.8;
m1=2;
m2=2;
l1=1;
l2=1;
tao1=30;
tao2=10;
tmax=6;
step=0.001;
%%求解微分方程
[t,y]=ode45('fshbai',[0:step:tmax],[0,0,0,0]);
%%绘图
huitu(tmax,t,y,step);
 
%%以下开始制作动画
figure(2);
%%坐标转换
x1=l1*sin(y(:,1));
y1=-l1*cos(y(:,1));
x2=x1+l2*sin(y(:,2));
y2=y1-l2*cos(y(:,2));
%%设置初始界面
xmin=min(x2);
xmax=max(x2);
ymin=min(y2);
ymax=max(y2);
text(-0.3,1.7,'双摆','fontsize',15)
axis equal
line([xmin xmax],[0,0],'linewidth',0.4);
line([0 0],[ymin ymax],'linewidth',0.4);
%%画初始位置
gan1=line([0,x1(1)],[0,y1(1)],'linewidth',...
    3,'color','g','erasemode','xor');
gan2=line([x1(1),x2(1)],[y1(1),y2(1)],...
    'linewidth',3,'color','g','erasemode','xor');
qiu1=line(x1(1),y1(1),'color','y','marker',...
    '.','markersize',40,'erasemode','xor');
qiu2=line(x2(1),y2(1),'color','y','marker',...
    '.','markersize',50,'erasemode','xor');
qiu11=line(x1(1),y1(1),'color','m',...
    'linestyle','-','linewidth',0.1,'erasemode','none');
qiu22=line(x2(1),y2(1),'color','r',...
    'linestyle','-','linewidth',0.1,'erasemode','none');
pause(0.5)
%%开始动画
for i=1:length(t)
    set(gan1,'XData',[0,x1(i)],'YData',[0,y1(i)]);
    set(gan2,'XData',[x1(i),x2(i)],'YData',[y1(i),y2(i)]);
    set(qiu1,'XData',x1(i),'YData',y1(i));
    set(qiu2,'XData',x2(i),'YData',y2(i));
    set(qiu11,'XData',x1(i),'YData',y1(i));
    set(qiu22,'XData',x2(i),'YData',y2(i));
    drawnow;
end