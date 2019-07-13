%y=x^2的函数图象
x=-10:10;                       %函数自变量范围    
y=x.^2;                         %函数关系
plot(x,y,'r-.')                 %函数图像

axis([-12,12,-1,102]);          %坐标轴范围
xlabel('X');
ylabel('Y');
title('y=x^2的函数图象');         
%text(8,60,'y=x^2');            %坐标标记
gtext('y=x^2')                  %用鼠标来标记
grid on;                        %网格
%grid off;                      %取消网格
