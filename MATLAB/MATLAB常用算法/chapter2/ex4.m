% ���õķ�������

%% ΢�ֺ���diff
clear;clc;
syms a x
f=sin(a*x)
dfx=diff(f,x)
dfa=diff(f,a)

%% ���ֺ��� int(integral)
clear;clc;
syms x
f=x*log(1+x)
int1=int(f,x)
int2=int(f,x,0,1)
