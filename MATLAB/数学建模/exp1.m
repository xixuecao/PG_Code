%% =*=*=*=*=*=*=*=  数学建模  =*=*=*=*=*=*=*=*=*=
%
% 题目
%
% 作者：卢博
% 该程序需要关联的其他文件包括
%   sampleDataSets.txt——采样数据
% 该程序需要关联的其他函数包括
%   PlotData.m——绘图函数
%   GradDesc.m——梯度下降法
%   CompCost.m——成本函数
%

%% 初始化
clear all;close all;clc;

%% =======第一部分：绘制采样数据的图形=============
disp('Step 1:Plotting Data...')
% 导入采样数据
data=load('sampleDataSets.txt');
% 分配数据
%X城市人口数(万人)
%Y参考房价(十万)
X=data(:,1);y=data(:,2);
m=length(y);
% 绘图
PlotData(X,y);
pause;
%% =======第二部分：使用梯度下降法求算theta值========
disp('Step 2:Finding theta by Gradient Descent...')
% 初始化及参数设置
X=[ones(m,1),data(:,1)];
theta=zeros(2,1);
alpha=0.01;
iterations=1600;
%计算成本
J00=CompCost(X,y,theta,m);
%梯度下降法求算theta
theta= GradDesc(X,y,theta,m,alpha,iterations);
disp(['Theta0=',num2str(theta(1)),' Theta1=',num2str(theta(2))])
%绘制线性回归方程
hold on
plot(X(:,2),X*theta)
legend('样本数据','一元线性回归')
%预测城市人口为4万人，8万人时的房价
predict1=[1 4]*theta;
disp(['@population=40000,the predicted price=',num2str(predict1*100000)])
predict2=[1 8]*theta;
disp(['@population=80000,the predicted price=',num2str(predict2*100000)])
%% =======第三部分：可视化成本函数J(theta)=========
disp('Step 3:Visualizing Cost Function J(theta)...')

%计算并记录成本函数的值
theta0_vals=linspace(-10,10,100);
theta1_vals=linspace(-1,4,100);
J_vals=[];
for i=1:length(theta0_vals)
    for j=1:length(theta1_vals)
        t=[theta0_vals(i);theta1_vals(j)];
        J_vals(i,j)=CompCost(X,y,t,m);
    end
end
%绘制曲面图
figure;
surf(theta0_vals,theta1_vals,J_vals)
xlabel('\theta_0');ylabel('\theta_1');xlabel('J(\theta)');
%绘制等高线图
figure;
contour(theta0_vals,theta1_vals,J_vals,logspace(-2,3,30))
%成本函数的值做对数处理
xlabel('\theta0');ylabel('\theta1');
hold on;
plot(theta(1),theta(2),'m*','MarkerSize',10,'LineWidth',2)