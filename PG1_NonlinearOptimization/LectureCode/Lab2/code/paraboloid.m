function paraboloid(x)
x0 = x(1);y0 = x(2);
%% ����ԭ���������ݶ�
f =@(x,y) x.^2 + y.^2;
[X, Y] = meshgrid(-2:0.05:2);
[fx,fy] = gradient(f(X,Y),0.05); % ��0.05��X Y�������ݶ�
%% �ҵ�����������
t = (X == x0) & (Y == y0); % �ҵ�������index
index = find(t);
fx0 = fx(index); 
fy0 = fy(index); % �õ����淨��x y
z = @(x,y) f(x0,y0) + fx0*(x-x0) + fy0*(y-y0);
%% ����ԭ���������� �����е㴦���
mesh(X,Y,f(X,Y))
hold on
mesh(X,Y,z(X,Y))
plot3(x0,y0,f(x0,y0),'r*') % ����е�
xlabel('X')
ylabel('Y')

end

