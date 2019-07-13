syms x(t) y(t) z(t) g l R w
s=dsolve('D2x=2*x*(Dy)^2','2*Dx*Dy=-x*D2y','sin(z)*D2z+cos(z)*Dz^2=-g/l','R^2+x^2-2*R*x*cos(w*t-y)-l^2*sin(z)^2=0')
x=simplify(s.x)
y=simplify(s.y)
%z=simplify(s.z)