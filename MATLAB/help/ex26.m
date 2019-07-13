clear;clc;
syms rs B x1 y1;
n=500;                               % �������
R=50.8;                              % ��Ƭ��С
t=0:0.02:2*pi; 
plot(R*cos(t),R*sin(t),'r');         % ����Ƭ
axis square 
hold on 
r=R*sqrt(rand(1,n));                 % �������
seta=2*pi*rand(1,n);                 % �����Ƕ�
x=r.*cos(seta); 
y=r.*sin(seta); 
plot(x,y,'*')                        % �������
hold on;

rs=sqrt(95^2+r.^2-190*r.*cos(pi-seta))
B=acos((95^2+rs.^2-r.^2)./(190*rs))


wp=60;
e=95;
k=0.8;
t=0:0.001:5;
ww=wp/k;                               % ���㹤��ת��
x1=rs.*cos(B+wp*t-ww*t)-e*cos(ww*t);
y1=rs.*sin(B+wp*t-ww*t)+e*sin(ww*t);     % ����켣������
plot(x1,y1); 
hold on ;                              % ����ͼ��