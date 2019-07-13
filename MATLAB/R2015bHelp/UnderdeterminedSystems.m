clear;clc;
R=[6 8 7 3; 3 5 4 1]
rng(0);
b=randi(8,2,1)

format rat
p=R\b
q = [-2; 1];
Z = null(R,'r')
x = p + Z*q

format short
norm(R*x - b)