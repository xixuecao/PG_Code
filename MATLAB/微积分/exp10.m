%AbsTol ¾ø¶ÔÎó²î
%RelTol Ïà¶ÔÎó²î

fun=@(x)log(x);
format long
integral(fun,0,1,'RelTol',0,'AbsTol',1e-12)