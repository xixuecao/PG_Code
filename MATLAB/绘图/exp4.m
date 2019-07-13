t=0:pi/50:2*pi;

x=8*cos(t);
y=4*sqrt(2)*sin(t);
z=-4*sqrt(2)*sin(t);

plot3(x,y,z,'P')
title('Line in 3D Space');
xlabel('X');ylabel('Y');zlabel('Z');
grid on;