syms r(t) t w l R g
r(t)=dsolve('D2r-r*w^2+l^2*(R-r)/(l^2-(R-r)^2)^2+g*(R-r)/(l^2-(R-r)^2)^1/2','t')
simplify(r)