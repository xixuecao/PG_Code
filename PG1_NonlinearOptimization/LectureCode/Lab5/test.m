S = {x(1), ..., x(n)}; ��= 1, r= 2,��= 0.5, ��= 0.5;
while ~termination_condition
order simplex vertices: f(x(1)) �� f(x(2)) �� ... f(x(n+1));
calculate center of gravity x(0)of all points but x(n+1);
xr= (1+��)x(0)-��x(n+1);% reflection
iff(x(1)) �� f(xr) <f(x(n))
update simplex with xrinstead of x(n+1);
elseif f(xr) <f(x(1))% expansion
xe= rxr+(1-r)x(0);
iff(xe) < f(xr)
update simplex with xeinstead of x(n+1);
else
update simplex with xrinstead of x(n+1);
end
elseiff(x(n)) �� f(xr) <f(x(n+1))% contraction
xc= (1+��)x(0)-��x(n+1);
iff(xc) �� f(xr)
update simplex with xcinstead of x(n+1);
else% shrink step
x(i)= x(1)+ ��(x(i)-x(1)) for i= 1, 2, ..., n+1;
end
else% shrink step
x(i)= x(1)+ ��(x(i)-x(1)) for i= 1, 2, ..., n+1;
end
end