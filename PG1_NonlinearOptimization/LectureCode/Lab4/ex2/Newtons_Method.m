function y = Newtons_Method(f,x)
% 直接带入公式即可
while abs(subs(f,x)) >= 1e-6
    fx = subs(diff(f),x);
    newx = x - subs(f,x)/fx;
    line([newx x],[0 subs(f,x)])
    line([newx newx],[0 subs(f,newx)],'linestyle','--');
    x = newx;
end
y = x;
end

