% clear;clc
figure
axis([0 20 0 20])
dots.x = round(rand(1, 150)*20);
dots.y = round(rand(1, 150)*20);
plot(dots.x, dots.y, 'ro','MarkerFaceColor','r');
grid on
hold on
temp = 0;
h = [];
i = 0;
while temp~= 20
    i = i + 1;
    set(h,'visible','off');
    [dot, h] = findpath_go(dots);
    temp = dot.y;
end
disp(['尝试', num2str(i), '次到达顶部']);


