%��ͼ
close all; %�رմ��˵�ͼ�δ���
clear; %�������
clc;
t=0:pi/20:4*pi;
hold on
axis([0 4*pi -10 10]);%���귶Χ
plot(t,10*sin(t),'r+:',t,5*cos(t),'b*--');
xlabel('ʱ��t');ylabel('��ֵx');%��ע��������
title('�򵥻�ͼ');%����
legend('x1=10sint:�㻭��','x2=5cost:����');
gtext('x1');gtext('x2');
grid on