% 已知空间三个点的坐标，如何计算出空间圆的表达式，并画出图形

clear;clc;

pos = rand(3);                               % 一行一个点
warning('error','MATLAB:nearlySingularMatrix')
warning('error','MATLAB:singularMatrix')
d = 1;
try
    n = (pos\ones(3,1))';
catch
    d = 0;
    n = null(pos)';
end
o = [diff(pos);n]\[diff(sum(pos.^2,2))/2;d]; % 圆心
r = norm(pos(1,:)-o');                       % 半径
[x,y,z] = sphere(40);
x = r*x+o(1);
y = r*y+o(2);
z = r*z+o(3);
zf = @(X)-(n(1)*X{1}+n(2)*X{2}-d)/n(3);
plot3(pos(:,1),pos(:,2),pos(:,3),'mo',o(1),o(2),o(3),'r*')
hold on
[~,h] = contour(x,y,zf({x,y})-z,[0 0],'b');
hold off
h = get(h,'child');
set(h,'zdata',zf(get(h,{'xdata','ydata'})))
grid on
daspect([1 1 1])