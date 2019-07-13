function f=three_peaks(x)
m=2;
f=3*exp(-norm(x-[1 2]')^2/m)+4*exp(-norm(x-[-2 1]')^2/m)+2*exp(-norm(x-[0 -2]')^2/m);