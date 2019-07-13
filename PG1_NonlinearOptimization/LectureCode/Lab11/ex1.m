clear;clc
%% Q1
f = @(x,y) exp(-x/2-y/3);
data = [[0 0];[0 2];[0 4];[2 0];[2 2];[2 4];[4 0];[4 2];[4 4]];
s = [];
for i = 1 : size(data,1)
    s = [s;f(data(i,1),data(i,2))];
end
%% Q2
% s1 = lambda0 + lambda1*x1 + lambda2*x2

X1 = [ones(size(data,1),1),data];
lambda1 = inv(X1'*X1)*X1'*s;
s1 = @(x,y) lambda1(1) + lambda1(2)*x + lambda1(3)*y;
%% Q3
% s2 = lambda0 + lambda1*x1 + lambda2*x2 + lambda3*x1*x2 + lambda4*x1^2 + lambda5*x2^2

X2 = [ones(size(data,1),1),data,data(:,1).*data(:,2),data(:,1).^2,data(:,2).^2];
lambda2 = inv(X2'*X2)*X2'*s;
s2 = @(x,y) lambda2(1) + lambda2(2)*x + lambda2(3)*y + lambda2(4)*x.*y + lambda2(5)*x.^2 + lambda2(6)*y.^2;
%% Q4 & Q5
% fmesh(f,[0 4 0 4])
[x,y] = meshgrid(0:0.05:4);

subplot(131)
mesh(x,y,f(x,y))

subplot(132)
mesh(x,y,s1(x,y))
hold on
plot3(data(:,1),data(:,2),f(data(:,1),data(:,2)),'rx')

subplot(133)
mesh(x,y,s2(x,y))
hold on
plot3(data(:,1),data(:,2),f(data(:,1),data(:,2)),'rx')

%% Q6
error1 = sum((f(data(:,1),data(:,2))-s1(data(:,1),data(:,2))).^2)

error2 = sum((f(data(:,1),data(:,2))-s2(data(:,1),data(:,2))).^2)