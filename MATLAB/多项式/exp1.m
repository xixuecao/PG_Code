%一维插值1
clear all;close all;

years=1900:10:2010;
production=[75.995,91.972,105.711,123.203,131.699,...
    150.697,179.323,203.212,226.505,249.633,256.344,...
    267.893];

p1988=interp1(years,production,1988,'spline')

x=1900:2010;
y=interp1(years,production,x,'spline');
plot(years,production,'o',x,y)
hold on
plot(1988,p1988,'*r')
text(1988,p1988-10,['1988年产量',num2str(p1988)])
