close all;
clear;
clc;

%% Sample Generate
N=5000;
a_real =[3/10,5/10,2/10];
mu_real = [7,12;12,7;14,15];
cov_real(:,:,1) = [1,0;0,1];
cov_real(:,:,2) = [3,1;1,3];
cov_real(:,:,3) = [3,1;1,3];
X_1 = mvnrnd(mu_real(1,:),cov_real(:,:,1),N*a_real(1));
X_2 = mvnrnd(mu_real(2,:),cov_real(:,:,2),N*a_real(2));
X_3 = mvnrnd(mu_real(3,:),cov_real(:,:,2),N*a_real(3));

X=[X_1;X_2;X_3];
X = X(randperm(size(X,1)),:);


%% Parameter Initialization
a = [1/3, 1/3,1/3];
cov(:,:,1) = [1,0;0,1];
cov(:,:,2) = [1,0;0,1];
cov(:,:,3) = [1,0;0,1];
mu_y_init = (max(X(:,1))+min(X(:,1)))/2;
mu_x1_init = max(X(:,2))/4+3*min(X(:,2))/4;
mu_x2_init = 2*max(X(:,2))/4+2*min(X(:,2))/4;
mu_x3_init = 3*max(X(:,2))/4+1*min(X(:,2))/4;
w = zeros(size(X,1),length(a)); %%w(i,j),i������������j�Ǿ���������w(i,j)��ֵ��ʾ����i���ھ���j�ĸ��ʣ����ֵ��ʾi�ľ���
mu = [mu_x1_init,mu_y_init;mu_x2_init,mu_y_init;mu_x3_init,mu_y_init];

%% EM Implementation
iter = 40;
for i = 1:iter
    %% Expectaion: �������еģ����µõ��ģ���˹�ֲ���������ʣ�����ÿһ����������ÿһ������ĸ���
    for j = 1 : length(a)
        w(:,j)=a(j)*mvnpdf(X,mu(j,:),cov(:,:,j));
    end   
w=w./repmat(sum(w,2),1,size(w,2)); %%Ϊ�˷���./���㣬����һ����wһ����ģ�ľ��󣬾����������ͬ�ģ�ÿһ����w(:,1)+w(:,2)��ֵ

%% Maximum: �������еģ����µõ��ģ���ÿһ����������ÿһ������ĸ��ʣ�����������ʺ͸�˹����
    a = sum(w,1)./size(w,1); %%��w��ÿһ�м��������ܵõ�ÿһ��������������
    
    mu = w'*X; %%�ֱ�õ�Xÿһά����ÿһ�������������mu(i,j),i��ά����j�Ǿ�����
    mu= mu./repmat((sum(w,1))',1,size(mu,2));
        
    for j = 1 : length(a)
        vari = repmat(w(:,j),1,size(X,2)).*(X- repmat(mu(j,:),size(X,1),1)); %%�õ�һ���ض�����Xÿһά�ķ�����󣬳���w�����൱��ѡ������ڸþ����X��
        cov(:,:,j) = (vari'*vari)/sum(w(:,j),1);      
    end
end

%% Estimation
[c estimate] = max(w,[],2);



%% Build-in EM Implementation

%options = statset('Display','final');
%gm = gmdistribution.fit(X,2,'Options',options);
%subplot(2,2,4);
%ezcontour(@(x,y)pdf(gm,[x y]),[0 20],[0 20]);