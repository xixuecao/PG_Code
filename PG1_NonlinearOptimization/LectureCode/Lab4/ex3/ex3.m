clear;clc;
syms x x1 x2;
x10 = [5;3];
f1 = exp(x1/5 + x2/2) + x1^2 + x2^2;
x20 = 2;
f2 = cos(x);

[ans1,iter1] = Trust_Region(f1,[x1;x2],x10,1,0.25,0.75,1e-3);
final_f1 = double(subs(f1,[x1;x2],ans1))
[ans2,iter2] = Trust_Region(f2,[x],x20,1,0.25,0.75,1e-3);
final_f2 = double(subs(f2,ans2))