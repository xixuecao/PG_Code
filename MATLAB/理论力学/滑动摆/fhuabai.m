function ydot=fhuabai(t,y)
global a w
x1=[a+1 cos(y(2))
   cos(y(2)) 1];
x2=[y(4)*y(4)*sin(y(2))
   -w*w*sin(y(2))];
ydot=[y(3)
   y(4)
   inv(x1)*x2];