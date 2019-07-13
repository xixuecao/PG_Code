clear;clc;
[X, Y]=meshgrid(-2:.1:2);
Z=exp(X.*Y);
mesh(X,Y,Z)