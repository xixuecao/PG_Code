%复数的绘图polar
clear;clc;
t=0:0.01:2*pi;y=t+1i*t.*sin(t);%直角坐标表示
r=abs(y);delta=angle(y);%极坐标表示

subplot(2,1,1);
plot(y);%画直角坐标图
title('直角坐标图');

subplot(212)
polar(delta,r)%画极坐标图
title('极坐标图');
