function Polynomial_Interpolation(data)
%% ����ˮƽ����y=0 ������ԭ����
x = [];y = [];
figure
hold on
grid on
line([0 7],[0 0],'color','red')
axis([0 7 -50 20])
for i = 1:length(data)
    x = [x data{i}(1)];
    y = [y data{i}(2)];
end
plot(x,y,'bo')
%% ��ԭ���ݲ�ֵ �õ���ӦY����
X = 0:0.01:7;
Y = interp1(x,y,X,'spline');
plot(X,Y,'k');
%% ��ϲ�ֵ��ĺ��� �����һ�׵�
p = polyfit(X,Y,8);
fp = p(1:8).*[8:-1:1];
plot(X,polyval(fp, X),'b')
%% �����Сֵ
index = find(abs(polyval(fp, X) - 0) < 7e-2); % �������ڲ�ֵ�õ���Y���겢�������õ���0��ֻ���ж�������0
xp = X(index);yp = Y(index);
plot(xp,yp,'r*');
for i=1:length(index)
    line([xp(i) xp(i)],[0 yp(i)],'color','red','linestyle','--')
end
end

