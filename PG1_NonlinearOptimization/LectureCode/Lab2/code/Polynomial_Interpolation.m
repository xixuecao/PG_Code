function Polynomial_Interpolation(data)
%% 画出水平红线y=0 并画出原数据
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
%% 对原数据插值 得到对应Y坐标
X = 0:0.01:7;
Y = interp1(x,y,X,'spline');
plot(X,Y,'k');
%% 拟合插值后的函数 并求得一阶导
p = polyfit(X,Y,8);
fp = p(1:8).*[8:-1:1];
plot(X,polyval(fp, X),'b')
%% 最大最小值
index = find(abs(polyval(fp, X) - 0) < 7e-2); % 这里由于插值得到的Y坐标并不会正好等于0，只能判断趋近于0
xp = X(index);yp = Y(index);
plot(xp,yp,'r*');
for i=1:length(index)
    line([xp(i) xp(i)],[0 yp(i)],'color','red','linestyle','--')
end
end

