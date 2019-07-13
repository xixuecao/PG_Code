%直接求值 
f=@(x)exp(-x.^2);
integral(f,0,1)

%f=sym('exp(-x^2)');
%int(f,0,1)