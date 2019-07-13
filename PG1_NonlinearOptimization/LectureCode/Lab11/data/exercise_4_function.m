function f=exercise_4_function(x)
f=2*exp(-norm(x+[1 1]')^2)+4*exp(-norm(x-[1 2]')^2)+3*exp(-norm(x+[2 -3]')^2)+x(1)^2/3-x(2)^2/4;
