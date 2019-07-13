%% Exercise 2
%{
1.  Implement data classification with EM method;
2.  Plot the figure of classification results，as shown in the following 
    figure. Note: the results shown below are just one example, and you may 
    have different results due to different initialization parameters.
%}

clear;clc
load data_c3_2
% Cluster_mean 每类样本在对应维度上的均值
% Cluster_std  每类样本对应的协方差矩阵
% ndata        样本总数
% ndim         每个样本维度
% Perm1        随机样本顺序，用于初始化参数
% Y            样本集
% 有4个sets
scatter(Y(:,1),Y(:,2),'.')
title('Clustring result')
Y0 = Y(perm1',:);
hold on

options = statset('MaxIter',20,'Display','final');
obj = gmdistribution.fit(Y,3,'options',options);  

f = @(x,y)pdf(obj,[x y]);
h = fcontour(f,[-5 10 -3 7]);

