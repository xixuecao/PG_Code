function [dot,l,flag] = fcross(x,l,f)
flag = true;
xtemp = [x(1),x(1)+l,x(1)-l,x(1),x(1)];
ytemp = [x(2),x(2),x(2),x(2)+l,x(2)-l];
plot(xtemp,ytemp,'bo')
for j = 2:5
    line([x(1),xtemp(j)],[x(2),ytemp(j)])
end
dots = [xtemp',ytemp',f(xtemp,ytemp)'];
%% sort the dots
temp = dots(:,1:2);
[dots(:,3),idx] = sort(dots(:,3));
dots(:,1:2) = temp(idx,1:2);
%% dots judge
dot_value = dots(1,3);
% disp(['此时xinit:',num2str(x),' 函数值',num2str(f(x(1),x(2)))])
% dots
if f(x(1),x(2)) == dot_value
    dot = x;
    l = l/3;
else
    if abs(f(x(1),x(2)) - dot_value) < 1e-15
        flag = false;
    end
    plot(dots(1,1),dots(1,2),'ro')
    dot = dots(1,1:2);
end
end

