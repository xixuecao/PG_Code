% ����y=(1+1./x).^xͼ��
clear;clc;
x=logspace(1,3); 
y=(1+1./x).^x;
plot(x,y)