% 想求∫[cosax/(1+4a^2 x^2 )]/(1+4a^2 x^2 )dx 解不出来
clear;clc;
syms x a
int(cos(a*x)/(1+4*a^2*x^2)^2)
