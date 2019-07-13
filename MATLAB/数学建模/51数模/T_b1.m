clear;clc;
data1= load('Data1.txt');
data2= load('Data2.txt');
X=data1(:,1);y=data1(:,2);z=data2(:,2);m=data2(:,3);
plot(X,y,'o',X,y,'r');
hold on;
%plot([0 2725],[0.25,0.25],'b');
%plot([0 2725],[0.3,0.3],'g');
hold off;
