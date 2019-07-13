function R=ota_c(x,omega)
for j=1:length(omega)
    R(j)=x(3)^2/sqrt((x(3)^2-omega(j)^2*x(1)*x(2))^2+(omega(j)*x(1)*x(3))^2);
end
R=R';