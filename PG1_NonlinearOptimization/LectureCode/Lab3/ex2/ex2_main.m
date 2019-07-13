clear;clc
W = 12;
rects = [randi([1 12], 40, 1), randi([1 10], 40, 1)]; % 随机生成矩形
figure
%% 优化前
subplot(1,2,1)
low_level = zeros(1,12); % 初始化水平高度
axis([0 12 0 190])
line([0 12],[0 0],'color','black','linewidth',2.5)
line([0 0],[0 180],'color','black','linewidth',2.5)
line([12 12],[0 180],'color','black','linewidth',2.5) % 画出边框
hold on

for i = 1:length(rects) % 每一行表示一个矩形
    out_level = fit(low_level,rects(i,:));
    low_level = out_level;
end
line([0 12], [max(low_level), max(low_level)], 'LineWidth', 2)
hold off
xlabel(['Bin height = ',num2str(max(low_level))]) % 显示最后水平高度的最大值
%% 优化后
subplot(1,2,2)
low_level = zeros(1,12); % 初始化水平高度
axis([0 12 0 190])
line([0 12],[0 0],'color','black','linewidth',2.5)
line([0 0],[0 180],'color','black','linewidth',2.5)
line([12 12],[0 180],'color','black','linewidth',2.5) % 画出边框
hold on

low_level = opfit(low_level,rects);
line([0 12], [max(low_level), max(low_level)], 'LineWidth', 2)
hold off
xlabel(['Bin height = ',num2str(max(low_level))]) % 显示最后水平高度的最大值