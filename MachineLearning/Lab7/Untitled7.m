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
