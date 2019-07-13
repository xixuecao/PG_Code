%泰勒展开3

syms x
f=sin(x)/x;
t6=taylor(f,'order',6);
t8=taylor(f,'order',8);
t10=taylor(f,'order',10);

L1=ezplot(t6,[-10,10]);set(L1,'color','r','LineWidth',3);
hold on
L2=ezplot(t8,[-10,10]);set(L2,'color','y','LineWidth',3);
L3=ezplot(t10,[-10,10]);set(L3,'color','b','LineWidth',3);
L=ezplot(f,[-10,10]);set(L,'color','g','LineWidth',3);

legend('sin(x)/x截断6阶小量','sin(x)/x截断8阶小量',...
    'sin(x)/x截断10阶小量','sin(x)/x','Location','Northeast')
title('泰勒级数展开')
hold off