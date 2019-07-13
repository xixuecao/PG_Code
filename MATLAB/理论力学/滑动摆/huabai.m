%%��ʼ��
global a w
a=2;
w=1;
L0=1;
theta0=pi/2;
tmax=30;
step=0.001;
%%���΢�ַ���
[t,y]=ode45('fhuabai',[0:step:tmax],[0,theta0,0,0]);
%%���û�ͼ������ͼ
huitu(tmax,t,y,step);
 
%%���¿�ʼ����������ʾ
figure(2);
%%����ת��
x1=L0*sin(y(:,2))+y(:,1);
y1=-L0*cos(y(:,2));
%%��ʼ����������
axis equal
xmin=min(min(y(:,1)),min(x1));
xmax=max(max(y(:,1)),max(x1));
ymin=min(y1(:));
ymax=max(max(y1(:)),0.1);
title('������','fontsize',15)
axis([xmin,xmax,ymin,ymax])
axis equal
hold on
line([xmin xmax],[0,0],'linewidth',2);
line([0 0],[ymin 0],'linewidth',0.4);
%%����ʼλ��
kuai=line([y(1,1)-0.04,y(1,1)+0.04],[0,0],...
    'linewidth',15,'color','k','erasemode','xor');
gan=line([0,x1(1)],[0,y1(1)],'linewidth',...
    3,'color','g','erasemode','xor');
qiu=line(x1(1),y1(1),'color','y','marker',...
    '.','markersize',50,'erasemode','xor');
qiu2=line(x1(1),y1(1),'color',[0,0,1],...
    'linestyle','-','linewidth',0.1,'erasemode','none');
pause(0.5)
%%��ʼ����
for i=1:length(t)
    set(kuai,'XData',[y(i,1)-0.04,...
            y(i,1)+0.04],'YData',[0,0]);
    set(gan,'XData',[y(i,1),x1(i)],'YData',[0,y1(i)]);
    set(qiu,'XData',x1(i),'YData',y1(i));
    set(qiu2,'XData',x1(i),'YData',y1(i),...
        'color',[i/length(t),i/length(t),1-i/length(t)]);
    drawnow;
end