%ArrayValued 数组值函数的标志

fun=@(x)sin((1:5).*x);
q=integral(fun,0,1,'ArrayValued',true)