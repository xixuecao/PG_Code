function ex12main()
clear;clc;
global D
D=1;
b1=-2;
b2=2;
t=b1+(0:100)/100*(b2-b1);
plot(t,ex12(t))
end
