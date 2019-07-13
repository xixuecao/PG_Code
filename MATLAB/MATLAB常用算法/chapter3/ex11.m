% 例外处理机制
function p=ex11(a,b)
if nargin==1
    b=zeros(4,1);
elseif nargin==0
    error('empty input');
end
a=a(:).';b=b(:).';
na=length(a);
nb=length(b);
p=[zeros(1,nb-na) a]+[zeros(1,na-nb) b];
