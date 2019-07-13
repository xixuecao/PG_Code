function nor_path(dots)
%% 画出数据点

axis([0 100 0 100])
n = length(dots); % n个点
plot(dots(:,1), dots(:,2), 'bo');
hold on
distance = 0; % 总距离此时为0
%% 连接点
for i = 1:n-1 % 起点到终点画n-1条线
    x1 = dots(i,1);
    y1 = dots(i,2);
    x2 = dots(i+1,1);
    y2 = dots(i+1,2);
    distance = distance + norm([x1 y1] - [x2 y2]);
    plot(x1,y1,'ro');
    plot(x2,y2,'ro');
    line([x1 x2],[y1 y2]); % 打点划线
end
%% 最后一根线
x0 = dots(1,1);
y0 = dots(1,2);
x40 = dots(40,1);
y40 = dots(40,2);
line([x0 x40],[y0 y40]) % 连接终点和起始点
xlabel(['Route Length = ',num2str(distance)]) % 显示最后总距离
end

