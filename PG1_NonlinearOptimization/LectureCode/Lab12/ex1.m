%% Response Correction Surrogate Model
clear;clc
%% 已知条件
syms x
f = exp(x/3)*0.1.*x.^2./(1+0.1*x.^2);
c = exp(x/3);
x0 = 3;
% 对已知的函数进行处理
fx = matlabFunction(f); % 转为句柄，方便直接带入x计算
df = diff(f); % 求导
dfx = matlabFunction(df); % 导数函数转为句柄
cx = matlabFunction(c); % 转为句柄，方便直接带入x计算
dc = diff(c); % 求导
dcx = matlabFunction(dc); % 导数函数转为句柄
%% beta-Correlation Method
% 画出原函数
subplot(121)
x = -5:0.1:5;
plot(x,fx(x),'b',x,cx(x),'k')
grid
hold on
% 1. Set up a surrogate model using a beta-correlation method at x(1)= 1 and then at x(1)= 3.
s = @(x) (fx(x0)/cx(x0) + (x-x0).*((dfx(x0).*cx(x0)-dcx(x0).*fx(x0))/(cx(x0)).^2)).*cx(x);
plot(x,s(x),'r',x,fx(x0) + dfx(x0).*(x-x0),'r.',x0,fx(x0),'ko')
legend("\itf(x)",'\itc(x)','\its(x)',"\itf(x_0)+f^'(x_0)(x - x_0)",'\itf(x_0)')
title(['x0 = ',num2str(x0)])
%% General Response Correction
% 画出原函数
subplot(122)
plot(x,fx(x),'b',x,cx(x),'k')
grid
hold on
% 2. Set up a surrogate model using a general response correction at x(1)= 1 and then at x(1)= 3.
s = @(x) fx(x0) + dfx(x0)./dcx(x0).*(cx(x)-cx(x0));
plot(x,s(x),'r',x,fx(x0) + dfx(x0).*(x-x0),'r.',x0,fx(x0),'ko')
legend("\itf(x)",'\itc(x)','\its(x)',"\itf(x_0)+f^'(x_0)(x - x_0)",'\itf(x_0)')
title(['x0 = ',num2str(x0)])
