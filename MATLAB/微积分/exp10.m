%AbsTol �������
%RelTol ������

fun=@(x)log(x);
format long
integral(fun,0,1,'RelTol',0,'AbsTol',1e-12)