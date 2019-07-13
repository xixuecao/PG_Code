%% Response Correction Surrogate Model
clear;clc
%% ��֪����
syms x
f = exp(x/3)*0.1.*x.^2./(1+0.1*x.^2);
c = exp(x/3);
x0 = 3;
% ����֪�ĺ������д���
fx = matlabFunction(f); % תΪ���������ֱ�Ӵ���x����
df = diff(f); % ��
dfx = matlabFunction(df); % ��������תΪ���
cx = matlabFunction(c); % תΪ���������ֱ�Ӵ���x����
dc = diff(c); % ��
dcx = matlabFunction(dc); % ��������תΪ���
%% beta-Correlation Method
% ����ԭ����
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
% ����ԭ����
subplot(122)
plot(x,fx(x),'b',x,cx(x),'k')
grid
hold on
% 2. Set up a surrogate model using a general response correction at x(1)= 1 and then at x(1)= 3.
s = @(x) fx(x0) + dfx(x0)./dcx(x0).*(cx(x)-cx(x0));
plot(x,s(x),'r',x,fx(x0) + dfx(x0).*(x-x0),'r.',x0,fx(x0),'ko')
legend("\itf(x)",'\itc(x)','\its(x)',"\itf(x_0)+f^'(x_0)(x - x_0)",'\itf(x_0)')
title(['x0 = ',num2str(x0)])
