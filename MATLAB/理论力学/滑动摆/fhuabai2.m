function ydot=fhuabai2(t,y)
global l g ma mb
x1=[ma+mb mb*l*cos(y(2))
   cos(y(2)) l];
x2=[y(4)*y(4)*mb*l*sin(y(2)) 
   -g*sin(y(2))];
ydot=[y(3)
   y(4)
   inv(x1)*x2];