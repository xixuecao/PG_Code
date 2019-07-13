syms t
y=sin(2*t).*exp(-0.5*t);
dy = diff(y);
dyf = matlabFunction(dy);
t = [0:0.01:5];
plot(t,subs(y));
x0 = [1,2,4];
x = arrayfun(@(x) fzero(dyf,x), x0)