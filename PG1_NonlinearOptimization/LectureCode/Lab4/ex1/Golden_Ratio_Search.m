function [y1,y2] = Golden_Ratio_Search(f,x)
t = (1 + sqrt(5))/2;
x1 = x(1);x2 = x(2);

while abs(x1 - x2) > 1e-3    
    x3 = x2 - (x2 - x1)/t;
    x4 = x1 + (x2 - x1)/t;
    fy = [f(x1) f(x2) f(x3) f(x4)];
    idx = find(fy == max(fy));
    if idx == 1
        x1 = x3;
    elseif idx == 2
        x2 = x4;
    elseif idx == [1,2]
        x1 = x3;
        x2 = x4;
    end
end

y1 = x1;
y2 = x2;
end

