% Ç¶Ì×¼ÆËã2
clear;clc;
% function ex10()
r=80;
M=160;
p=exp(-r);
S1=0;
for k=1:M
    p=p*r/k;
    S1=S1+p;
end
S1

S2=0;
q=exp(-r);
for k=1:M
    p=r^k/factorial(k);
    S2=S2+p*q;
end
S2*exp(-r);
S2
