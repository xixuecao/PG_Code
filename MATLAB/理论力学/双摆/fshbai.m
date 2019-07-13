function ydot=fshbai(t,y)
global l1 l2 g m1 m2 tao1 tao2
x1=[(m1+m2)*l1*l1  m2*l1*l2*cos(y(2)-y(1))
   m2*l1*l2*cos(y(2)-y(1)) m2*l2*l2];
x2=[tao1+m2*l1*l2*y(4)*y(4)*sin(y(2)-y(1))-(m1+m2)*l1*g*sin(y(1))
   tao2-m2*l1*l2*y(3)*y(3)*sin(y(2)-y(1))+m2*l2*g*sin(y(2))];
ydot=[y(3)
   y(4)
   inv(x1)*x2];