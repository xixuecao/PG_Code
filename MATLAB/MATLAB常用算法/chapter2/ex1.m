clear;clc;
a=[1 2 3;4 5 6];
%����
b=[a;11 12 13];
b(3,2);
b(:,3);
b(1,:);
b(2:3,2:3);

c=tril(b);

A=[1 2;3 4];
B=[2 1;4 3];
C=[10 7;22 15];
A\C
