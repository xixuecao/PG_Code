%“ªŒ¨≤Â÷µ3µ•Õº
clear all;close all;clc;

x=0:2:24;
y=[12 9 9 10 18 24 28 27 25 20 18 15 13];
xi=0:1/3600:24;

strmethod={'nearest','linear','next','previous','spline','pchip'};
strcolor={'y','g','c','b','m','r'};
for i=1:6
    yi=interp1(x,y,xi,strmethod{i});
    plot(xi,yi,strcolor{i},'linewidth',5-0.5i)
    hold on
end
plot(x,y,'ko','linewidth',5)
legend('(a)method=nerst','(b)method=linear',...
    '(c)method=next','(d)method=privious',...
    '(e)method=spline','(f)method=pchip');