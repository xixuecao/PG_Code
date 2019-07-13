clear;clc
x1 = 0;x2 = 10;
f1 = @(x) (x - 2).^2;
x3 = 0;x4 = 2*pi;
f2 = @(x) cos(x);
[x1,x2] = Golden_Ratio_Search(f1,[x1,x2]);
[x3,x4] = Golden_Ratio_Search(f2,[x3,x4]);

x_f1 = (x1 + x2)/2
x_f2 = (x3 + x4)/2