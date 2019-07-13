function distance = distans(dots)
%% 画出数据点

% axis([0 100 0 100])
n = length(dots); % n个点
% plot(dots(:,1), dots(:,2), 'bo');
% hold on
distance = 0; % 总距离此时为0
%% 连接点
for i = 1:n-1 % 起点到终点画n-1条线
    x1 = dots(i,1);
    y1 = dots(i,2);
    x2 = dots(i+1,1);
    y2 = dots(i+1,2);
    distance = distance + norm([x1 y1] - [x2 y2]);
end
%% 最后一根线
x0 = dots(1,1);
y0 = dots(1,2);
xf = dots(end,1);
yf = dots(end,2);
distance = distance + norm([x0 y0] - [xf yf]);
end

