%“ªŒ¨≤Â÷µ2∂‡Õº
clear;close all;clc;

x=0:2:24;
y=[12 9 9 10 18 24 28 27 25 20 18 15 13];
xi=0:1/3600:24;

strmethod={'nearest','linear','next','previous','spline','pchip'};
strlb={'(a)method=nerst','(b)method=linear',...
    '(c)method=next','(d)method=privious',...
    '(e)method=spline','(f)method=pchip'};

for i=1:6
    yi=interp1(x,y,xi,strmethod{i});
    subplot(3,2,i)
    plot(x,y,'ro',xi,yi,'b','linewidth',1.5)
    xlabel(strlb{i})
end