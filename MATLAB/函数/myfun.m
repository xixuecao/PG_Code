function F = myfun(x) 
global R; 
global omega; 
global l; 
global m; 
global g; 
F = [g/cos(x(2))-omega*omega*x(1)/sin(x(2));R/sin(x(2))+x(1)/sin(x(2))-l];
end