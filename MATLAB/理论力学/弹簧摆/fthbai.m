function ydot=fthbai(t,y)
global a
ydot=[y(3)
   y(4)
   (y(1)+1)*y(4)*y(4)-a*y(1)+cos(y(2))
   (-2*y(3)*y(4)-sin(y(2)))/(y(1)+1)];
end