function [sita1 ysita1] = jidian(Qe,olz,rr,ll)
syms sita
Qpp1=Qe+olz*[rr*cos(sita);rr*sin(sita);ll];
Si1=(Qpp1(1))^2+(Qpp1(2))^2;
sita1=double(solve(Qpp1(1).*olz(2,3)-Qpp1(2).*olz(1,3),sita));
Qpp11=Qe+olz*[rr*cos(sita1);rr*sin(sita1);ll];
ysita1=(Qpp11(1))^2+(Qpp11(2))^2;
end
