clear all;close all;clc;
%���ƻ�ƿ
t=0:pi/20:2*pi;
[X,Y,Z]=cylinder(2+sin(t),50);
surf(X,Y,Z,'LineStyle','none');
colormap(parula)
axis off