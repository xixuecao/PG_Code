function [F,xbest,fbest] = evaluate(fun,N,P,varargin)
j0 = 1; fbest = Inf;
if nargin>3
    j0 = 2;
    xbest = P(1,:);
    fbest = varargin{1};
    F(1) = fbest;
end
for j = j0:N
    F(j) = feval(fun,P(j,:));
    if F(j) < fbest
        xbest = P(j,:);
        fbest = F(j);
    end
end
end