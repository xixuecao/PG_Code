% 匿名函数创建
clear;clc;
myfhd1=@(x) (x+x.^2);
myfhd1(2)

myfhd2=@(x,y) (sin(x)+cos(y));
myfhd2(pi/2,pi/6)

myffhd=@(a) (quad(@(x) (a.*x.^2+1./a.*x+1./a^2),0,1))
myffhd(0.5)