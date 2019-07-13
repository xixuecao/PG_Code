clear;clc;
T=[300,400,500];
Ogold=185;
fun=@(x)x.^4./(exp(x)-1);
for k=1:numel(Ogold./T)
    intt(k)=integral(fun,0,Ogold./T(k));
end
intt