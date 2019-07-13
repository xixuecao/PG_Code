function y = SumAll( varargin )
if nargin == 0
    y = 0;
else
    temp = cell2mat(varargin);
    y = sum(temp(:));
end
end

