function ex13()
clear;clc;
global D
D=1;b1=-2;b2=2;
bounds=[b1 b2];
subplot(131);ex13plot('ex12')
axis([b1 b2 -0.4 1.2]);
subplot(132);ex13plot('ex12',bounds)
axis([b1 b2 -0.4 1.2]);
subplot(133);ex13plot('ex12',bounds,D)
axis([b1 b2 -0.4 1.2]);