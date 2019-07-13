%integral求多重积分

fun=@(x,y,z)y.*sin(x)+z.*cos(x);
integral3(fun,0,pi,0,1,-1,1)