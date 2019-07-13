function min_path(dots)
%% 画出数据点
axis([0 100 0 100])
n = length(dots); % n个点
plot(dots(:,1), dots(:,2), 'bo');
hold on
%% 计算不同点之间距离 并用排列组合的方式组成新矩阵
distance = 0; % 总距离此时为0
D = pdist(dots); % 计算不同点之间距离
dots_D = [nchoosek(1:n,2) D']; % 排列组合得到新矩阵 ex:[1 25 3.677] 第一个点和第25个点之间距离为3.677
%% 对每个点找到距离最近的点 连接 并且去掉这些数据 同时将"头"移动给下一个点 
temp = 1; % "头"设置为第一个点x1 = dots(1,1) y1 = dots(1,2)
for i = 1:n-1 % 起点到终点画n-1条线
    index = find(dots_D(:,1) == temp | dots_D(:,2) == temp); 
    temp_dots_D = dots_D(index,:); % 找到所有的距"头"点的距离 包括它到别的点和别的点到它
    mind = min(temp_dots_D(:,3)); % 在这些距离中找到最小值
    id = find(temp_dots_D(:,3)==mind); % 得到最小值的引索 即其他点到"头"点最小距离的组合方式 的引索
    k = id(1); % 有可能有多个点到"头"点距离都最小 只取一个
    x1 = dots(temp_dots_D(k,1),1);
    y1 = dots(temp_dots_D(k,1),2);
    x2 = dots(temp_dots_D(k,2),1);
    y2 = dots(temp_dots_D(k,2),2);
    %{
    这里k是行引索 temp_dots_D(k,:)得到的是[1 20 3.02] 
    即第一个点到第二十个点的距离为3.02 其中3.02是所有其他点到第一个点最小的距离
    %}
    distance = distance + norm([x1 y1] - [x2 y2]);
    plot(x1,y1,'ro');
    plot(x2,y2,'ro');
    line([x1 x2],[y1 y2]); % 打点划线
    if temp_dots_D(k,1) == temp
        temp = temp_dots_D(k,2);
    elseif temp_dots_D(k,2) == temp
        temp = temp_dots_D(k,1);
    end
    %{
    这个判断语句是为了传递"头"点,比如[1 20 3.02]
    如果现在的,已经被计算了的"头"点是第一个点,则"头"点传为第二十个点
    如果"头"点是第二十个点,则"头"点传为第一个点.
    %}
    dots_D(index,:) = []; % 清楚已经被计算了的"头"点所有距离信息，不论是它到别的点还是别的点到它
end
%% 最后一根线
x0 = dots(1,1);
y0 = dots(1,2);
x40 = dots(temp,1);
y40 = dots(temp,2);
line([x0 x40],[y0 y40]) % 连接终点和起始点
xlabel(['Route Length = ',num2str(distance)]) % 显示最后总距离
end

