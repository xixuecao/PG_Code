% 优化后的放置矩形的函数
function out_level = opfit(low_level,rects)
roy = [];
idx = [];
%% 筛选
% 矩形中高度小于2的旋转，然后把矩形中长度小于2的挑出来
for i = 1:length(rects)
    if rects(i,2) <= 2
        temp = rects(i,1);
        rects(i,1) = rects(i,2);
        rects(i,2) = temp;
    end
    if rects(i,1) <= 2
        roy = [roy;rects(i,:)];
        idx = [idx i];
    end
end
%% 排序
rects(idx,:) = []; % 把长度小于2的矩形去掉然后排倒序
a = rects;
b=a(:,1);
[c,pos]=sort(b);%pos为排序后的下标,c为第一行的排序结果; 
p = [c,pos];
X=eye(length(p)); 
X=rot90(X); 
p=X*p;
a(:,2)=a(p(:,2),2);%第二行按照第一行排序的下标对应 
a(:,1)=p(:,1);

aa = roy; % 长度小于2的矩形排正序
b=aa(:,1);
[c,pos]=sort(b);%pos为排序后的下标,c为第一行的排序结果; 
aa(:,2)=aa(pos,2);%第二行按照第一行排序的下标对应 
aa(:,1)=c;
%% 放入矩形
rects = [a(1:round(length(a)/2),:);aa;a(round(length(a)/2)+1:end,:)]; % 把长度小于2的矩形放在倒序的矩形中间
for i = 1:length(rects)
    out_level = fit(low_level,rects(i,:));
    low_level = out_level;
end
end

