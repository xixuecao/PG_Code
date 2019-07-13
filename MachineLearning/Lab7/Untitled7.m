%% EM Implementation
iter = 40;
for i = 1:iter
    %% Expectaion: 根据现有的（最新得到的）高斯分布和先验概率，计算每一个样本属于每一个聚类的概率
    for j = 1 : length(a)
        w(:,j)=a(j)*mvnpdf(X,mu(j,:),cov(:,:,j));
    end   
w=w./repmat(sum(w,2),1,size(w,2)); %%为了方便./计算，建立一个和w一样规模的矩阵，矩阵的列是相同的，每一行是w(:,1)+w(:,2)的值

%% Maximum: 根据现有的（最新得到的）的每一个样本属于每一个聚类的概率，计算先验概率和高斯参数
    a = sum(w,1)./size(w,1); %%把w的每一行加起来就能得到每一个聚类的先验概率
    
    mu = w'*X; %%分别得到X每一维对于每一个聚类的期望，mu(i,j),i是维数，j是聚类数
    mu= mu./repmat((sum(w,1))',1,size(mu,2));
        
    for j = 1 : length(a)
        vari = repmat(w(:,j),1,size(X,2)).*(X- repmat(mu(j,:),size(X,1),1)); %%得到一个特定聚类X每一维的方差矩阵，乘以w，（相当于选择出属于该聚类的X）
        cov(:,:,j) = (vari'*vari)/sum(w(:,j),1);      
    end
end

%% Estimation
[c estimate] = max(w,[],2);
