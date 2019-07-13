clear;clc;
hold on
grid on
axis equal

f1 = @(x) -sqrt(0.25-x.^2) + 0.5;
f2 = @(x) 1 - f1(x);
f3 = @(x) 1 - sqrt(2*x-x.^2);
f4 = @(x) 1 - f3(x);

x1 = linspace(0, 0.5, 500);
plot(x1, f1(x1), '-.', 'LineWidth', 1.2)
plot(x1, f2(x1), 'LineWidth', 1.2)

x2 = linspace(0, 1, 500);
plot(x2, f3(x2), 'LineWidth', 1.5)
plot(x2, f4(x2), 'LineWidth', 1.5)

xlabel('$x$', 'interpreter', 'latex', 'FontSize', 13)
ylabel('$y$', 'interpreter', 'latex', 'FontSize', 13)
title('Illustration to show the usage of function patch', ...
      'FontName', 'Arial', 'FontSize', 14)
labels = {'$f_1(x)$', '$f_2(x)$', '$f_3(x)$', '$f_4(x)$'};
legend(labels, 'interpreter', 'latex', 'FontSize', 12)

x_range = x2((f4(x2)>f3(x2)) & (x2<=0.5));  % 确定待填充区域的x范围
[y1, y2, y3, y4] = deal(f1(x_range), f2(x_range), f3(x_range), f4(x_range));
y_upper = min(y2, y4);  % 填充区域的上边界
y_lower = max(y1, y3);  % 填充区域的下边界

patch([x_range, fliplr(x_range)], [y_lower, fliplr(y_upper)], 'r')
alpha(0.65)