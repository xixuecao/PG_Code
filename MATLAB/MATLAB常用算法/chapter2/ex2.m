%�����Ļ�ͼpolar
clear;clc;
t=0:0.01:2*pi;y=t+1i*t.*sin(t);%ֱ�������ʾ
r=abs(y);delta=angle(y);%�������ʾ

subplot(2,1,1);
plot(y);%��ֱ������ͼ
title('ֱ������ͼ');

subplot(212)
polar(delta,r)%��������ͼ
title('������ͼ');
