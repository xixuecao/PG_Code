function [len,index] = con_size(x)
% 这里的x是引索,比如找到一个数组里面最小值的引索
% x = find(A == min(A));
% x = [1 2 3 6 7 8 9 10 22 35]
% con_size(x)来判断哪些是连续的，并且得到最长的连续引索[6 7 8 9 10]
d = diff(x(:))~=1; % 得到每两个数之间是否连续的逻辑数组
k = find([true;d;true]); % 在d前后补上1
r = [k(1:end-1) diff(k)]; % 得到每个引索对应连续个数
len = max(r(:,2)); % 最大连续长度
idx = find(r(:,2) == len);
index = r(idx,1);
end

