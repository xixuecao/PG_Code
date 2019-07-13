function Numerical_Methods(f,y,y0,h)
%% ��ʼֵ
yeuler = [y0]; % y0
yadams = [y0 y0 + h*f(0,y0)]; % y0 y1 
%% ��hΪ��࿪ʼ����
% ����ʽ����
h = 0.1;
t = 0:h:5;
i = 1;
for k = 1:50
    tempeuler = yeuler(i);
    tempadams1 = yadams(i);
    tempadams2 = yadams(i+1);
    i = i + 1; % ����yeuler��yadams
    yeuler = [yeuler tempeuler + h*f(t(k),tempeuler)];
    yadams = [yadams tempadams2 + 1.5*h*f(t(k+1),tempadams2) - 0.5*h*f(t(k),tempadams1)];
end
%% ������������
plot(t,y(t),'b') % ����ԭ�������ֵõ�
hold on
plot(t,yeuler,'k--')
plot(t,yadams(1:51),'k')
legend('Exact solution','Numerical solution (Euler)','Numerical solution (Adams-Bashforth)')
axis([0 5 -0.4 1])
grid on
end

