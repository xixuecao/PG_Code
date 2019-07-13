clear; clc; 
%% 训练阶段  
ReadList1 = textread('pos_list.txt','%s','delimiter','\n');% 正样本列表
sz1=size(ReadList1,1);
label1=ones(sz1,1); %正样本标签  

ReadList2 = textread('neg_list.txt','%s','delimiter','\n');% 负样本列表
sz2=size(ReadList2,1);
label2=-ones(sz2,1);%负样本标签

label=[label1',label2']';%标签汇总
total_num=length(label);
data=zeros(total_num,1764);

% 读取正样本并计算hog特征
for i=1:sz1
   name= char(ReadList1(i,1));
   image=imread(strcat('pos\',name));
   im=imresize(image,[64,64]);
   img=rgb2gray(im);
   hog =hogcal(img);
   data(i,:)=hog;
end

% 读取负样本并计算hog特征
for j=1:sz2
   name= char(ReadList2(j,1));
   image=imread(strcat('neg\',name));
   im=imresize(image,[64,64]);
   img=rgb2gray(im);
   hog =hogcal(img);
   data(sz1(1)+j,:)=hog;
end

[train, test] = crossvalind('holdOut',label); % 将总数据一分为二，一部分训练，一部分测试
svmStruct = Train_svm(data(train,:),label(train)); % 训练得到svmStruct，其实就是support vector
%% 测试阶段
classes = Predict_svm(svmStruct,data(test,:),label(test))

%% 这里是从训练集pos或者neg中随便抽取一张测试，看预测准不准
% load svmStruct
% test=imread('00000_00005.ppm');
% im=imresize(test,[64,64]);
% figure;
% imshow(im);
% img=rgb2gray(im);
% hogt =hogcal(img);
% Y = 1;
% classes = Predict_svm(svmStruct,hogt,Y) % classes的值即为分类结果

%% 随便从网上下载2张图片，都含有图形70
A=imread('70-2.jpg');
[m,n,ch]=size(A);
l = min(m,n);
sliding_window_size =250; % 滑动窗口大小
imshow(A)
hold on
pause()
for s = 1:length(sliding_window_size)
    num = sliding_window_size(s);
for k=1:num/5:m-num
   for kk=1:num/5:n-num
   B=A(k:k+num,kk:kk+num);
   im=imresize(B,[64,64]);
   hogt =hogcal(im);
   Y= 0;
   classes = Predict_svm(svmStruct,hogt,Y);
   h = rectangle('Position',[kk,k,num,num],'EdgeColor','k','LineWidth',3);
   if classes.Y == 1
       pause(0.5)
       rectangle('Position',[kk,k,num,num],'EdgeColor','r','LineWidth',3)
   end
   pause(0.25)
   set(h,'visible','off')
   end
end
end
