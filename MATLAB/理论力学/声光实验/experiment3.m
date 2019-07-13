clear;clc;
data=load('data3.txt');
p=data(:,1);I0=data(:,2);I1=data(:,3);
createFit1(p, I0)
hold on
createFit2(p, I1)
plot(p,I0,'.b-','MarkerSize',10)
plot(p,I1,'.b-','MarkerSize',10)
hold off
xlabel('P');ylabel('Id');
legend('I0','I0 vs.P','I1','I1 vs.P')
gtext('I0');gtext('I1')