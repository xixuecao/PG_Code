function [F,xbest,fbest] = evaluate(fun,xbest,P,varargin)
fbest = Inf;
if nargin>3
    fbest = varargin{1};
    F = fbest;
end

if feval(fun,P) < fbest
    F = feval(fun,P);
    xbest = P;
    fbest = F;
end
end
