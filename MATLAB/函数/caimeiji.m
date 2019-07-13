function dx = caimeiji(t,x)
global a1 a2 ch kn omega phi;
dx = zeros(2,1);    % a column vector
dx(1) = x(2);
dx(2) = -a1*ch*x(2)-a1*kn*x(1)+a2*sin(omega*t+phi);
end
 