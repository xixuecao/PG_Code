function Numerical_Methods(f,y,y0,h)
%% 初始值
yeuler = [y0]; % y0
yadams = [y0 y0 + h*f(0,y0)]; % y0 y1 
%% 以h为间距开始迭代
% 按公式输入
h = 0.1;
t = 0:h:5;
i = 1;
for k = 1:50
    tempeuler = yeuler(i);
    tempadams1 = yadams(i);
    tempadams2 = yadams(i+1);
    i = i + 1; % 增大yeuler和yadams
    yeuler = [yeuler tempeuler + h*f(t(k),tempeuler)];
    yadams = [yadams tempadams2 + 1.5*h*f(t(k+1),tempadams2) - 0.5*h*f(t(k),tempadams1)];
end
%% 画出三条曲线
plot(t,y(t),'b') % 这里原函数积分得到
hold on
plot(t,yeuler,'k--')
plot(t,yadams(1:51),'k')
legend('Exact solution','Numerical solution (Euler)','Numerical solution (Adams-Bashforth)')
axis([0 5 -0.4 1])
grid on
end

