clear;clc;
data=load('data2.txt');
f=data(:,1);I1=data(:,2);
cftool
pause
hold on
plot(f,I1,'.-','MarkerSize',10)
xlabel('f');ylabel('I1');