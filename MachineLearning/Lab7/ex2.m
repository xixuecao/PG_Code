%% Exercise 2
%{
1.  Implement data classification with EM method;
2.  Plot the figure of classification results��as shown in the following 
    figure. Note: the results shown below are just one example, and you may 
    have different results due to different initialization parameters.
%}

clear;clc
load data_c3_2
% Cluster_mean ÿ�������ڶ�Ӧά���ϵľ�ֵ
% Cluster_std  ÿ��������Ӧ��Э�������
% ndata        ��������
% ndim         ÿ������ά��
% Perm1        �������˳�����ڳ�ʼ������
% Y            ������
% ��4��sets
scatter(Y(:,1),Y(:,2),'.')
title('Clustring result')
Y0 = Y(perm1',:);
hold on

options = statset('MaxIter',20,'Display','final');
obj = gmdistribution.fit(Y,3,'options',options);  

f = @(x,y)pdf(obj,[x y]);
h = fcontour(f,[-5 10 -3 7]);

