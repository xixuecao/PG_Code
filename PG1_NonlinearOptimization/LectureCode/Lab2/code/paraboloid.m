function paraboloid(x)
x0 = x(1);y0 = x(2);
%% 创建原函数并求梯度
f =@(x,y) x.^2 + y.^2;
[X, Y] = meshgrid(-2:0.05:2);
[fx,fy] = gradient(f(X,Y),0.05); % 以0.05在X Y方向求梯度
%% 找到所求点的切面
t = (X == x0) & (Y == y0); % 找到所求点的index
index = find(t);
fx0 = fx(index); 
fy0 = fy(index); % 得到切面法线x y
z = @(x,y) f(x0,y0) + fx0*(x-x0) + fy0*(y-y0);
%% 画出原函数和切面 并在切点处标记
mesh(X,Y,f(X,Y))
hold on
mesh(X,Y,z(X,Y))
plot3(x0,y0,f(x0,y0),'r*') % 标记切点
xlabel('X')
ylabel('Y')

end

