clear;clc
% Plot the data. Nonlinear regression model that has no more than five parameters.
data = xlsread('ex3data.xlsx','A1:B51');
plot(data(:,1),data(:,2),'bx')
grid
hold on
% Obtain its parameters using lsqnonlin.
% y = l0 + l1*x + l2*x^2 + l3*x^3 + l4*x^4
x = (0:0.2:10)';
f = @(lambda) lambda(1) + lambda(2)*x + lambda(3)*x.^2 + lambda(4)*x.^3 + lambda(5)*x.^4 - data(:,2);
lambda = lsqnonlin(f,ones(5,1));
% Plot both the input data and the regression function.

fx = @(x) lambda(1) + lambda(2)*x + lambda(3)*x.^2 + lambda(4)*x.^3 + lambda(5)*x.^4;
plot(x,fx(x))
