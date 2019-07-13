clear;clc;
f = @ distans;
[x,y] = fga(f,50,0,100,0.8,0.8,2,3000);
subplot(122)
nor_path(x)
