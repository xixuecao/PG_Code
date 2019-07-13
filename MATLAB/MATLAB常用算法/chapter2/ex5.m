%画图
close all; %关闭打开了的图形窗口
clear; %清除变量
clc;
t=0:pi/20:4*pi;
hold on
axis([0 4*pi -10 10]);%坐标范围
plot(t,10*sin(t),'r+:',t,5*cos(t),'b*--');
xlabel('时间t');ylabel('幅值x');%标注横纵坐标
title('简单绘图');%标题
legend('x1=10sint:点画线','x2=5cost:虚线');
gtext('x1');gtext('x2');
grid on