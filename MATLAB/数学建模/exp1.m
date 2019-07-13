%% =*=*=*=*=*=*=*=  ��ѧ��ģ  =*=*=*=*=*=*=*=*=*=
%
% ��Ŀ
%
% ���ߣ�¬��
% �ó�����Ҫ�����������ļ�����
%   sampleDataSets.txt������������
% �ó�����Ҫ������������������
%   PlotData.m������ͼ����
%   GradDesc.m�����ݶ��½���
%   CompCost.m�����ɱ�����
%

%% ��ʼ��
clear all;close all;clc;

%% =======��һ���֣����Ʋ������ݵ�ͼ��=============
disp('Step 1:Plotting Data...')
% �����������
data=load('sampleDataSets.txt');
% ��������
%X�����˿���(����)
%Y�ο�����(ʮ��)
X=data(:,1);y=data(:,2);
m=length(y);
% ��ͼ
PlotData(X,y);
pause;
%% =======�ڶ����֣�ʹ���ݶ��½�������thetaֵ========
disp('Step 2:Finding theta by Gradient Descent...')
% ��ʼ������������
X=[ones(m,1),data(:,1)];
theta=zeros(2,1);
alpha=0.01;
iterations=1600;
%����ɱ�
J00=CompCost(X,y,theta,m);
%�ݶ��½�������theta
theta= GradDesc(X,y,theta,m,alpha,iterations);
disp(['Theta0=',num2str(theta(1)),' Theta1=',num2str(theta(2))])
%�������Իع鷽��
hold on
plot(X(:,2),X*theta)
legend('��������','һԪ���Իع�')
%Ԥ������˿�Ϊ4���ˣ�8����ʱ�ķ���
predict1=[1 4]*theta;
disp(['@population=40000,the predicted price=',num2str(predict1*100000)])
predict2=[1 8]*theta;
disp(['@population=80000,the predicted price=',num2str(predict2*100000)])
%% =======�������֣����ӻ��ɱ�����J(theta)=========
disp('Step 3:Visualizing Cost Function J(theta)...')

%���㲢��¼�ɱ�������ֵ
theta0_vals=linspace(-10,10,100);
theta1_vals=linspace(-1,4,100);
J_vals=[];
for i=1:length(theta0_vals)
    for j=1:length(theta1_vals)
        t=[theta0_vals(i);theta1_vals(j)];
        J_vals(i,j)=CompCost(X,y,t,m);
    end
end
%��������ͼ
figure;
surf(theta0_vals,theta1_vals,J_vals)
xlabel('\theta_0');ylabel('\theta_1');xlabel('J(\theta)');
%���Ƶȸ���ͼ
figure;
contour(theta0_vals,theta1_vals,J_vals,logspace(-2,3,30))
%�ɱ�������ֵ����������
xlabel('\theta0');ylabel('\theta1');
hold on;
plot(theta(1),theta(2),'m*','MarkerSize',10,'LineWidth',2)