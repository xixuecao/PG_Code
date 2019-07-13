% 优化前的放置矩形的函数
function [out_level,out_index,temp] = fit(low_level,rect)
x = rect(1);
y = rect(2);
A = low_level;
index = find(A == min(A));
[max_len, max_index] = con_size(index); % 找到此时水平高度里 最长的连续最小高度 的长度和引索
new_index = index(max_index(1):max_index(1)+max_len-1); % max_index最长的连续最小高度可能有多个，取其中一个
%% 当连续最小高度的长 大于等于 即将进入的矩形的水平长度
if max_len >= x
    out_index = new_index(1):new_index(1)+x-1; % 只输出 进入的矩形的长度对应的引索
    temp = A(out_index);
    for k = 1:x
        temp(k) = temp(k) + y; % 提高水平高度
    end
    X = [new_index(1)-1 x+new_index(1)-1 x+new_index(1)-1 new_index(1)-1];
    Y = [min(A) min(A) y+min(A) y+min(A)];
    fill(X,Y,'r'); % 填充矩形为红色
    A(out_index) = temp;
%% 当连续最小高度的长 小于 即将进入的矩形的水平长度
else 
    temp_A = A(index); % 找到所有的最小高度
    A(index) = 1000; % 把这些高度赋值为1000
    A(index) = min(A); % 再次找最小高度，这样就找到了原本高度里第二小的值，并将原来的最小高度赋值为第二小的高度
    low_level = A; % 用新的水平高度再次尝试
    [A,out_in,tmp] = fit(low_level,rect);
    out_index = out_in; % 当结果可以输出时把每次矩形长度对应的引索记录下来
    temp = tmp;
    A(index) = temp_A; % 将原本的最小高度复原，但是会吧填充了矩形的区域也复原
    A(out_in) = tmp; % 因此这一步就是把矩形区域对应的高度提高到至应高度
end
out_level = A;

end

