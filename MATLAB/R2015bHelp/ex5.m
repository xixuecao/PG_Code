x=-3:0.1:3;y=-3:0.1:3;
[X Y]=meshgrid(x,y);

a=5; b=4; c=3; d=1;
z=c.*(d-(X.^2)./(a^2)-(Y.^2)./(b^2)).^(1/2);
subplot(121);
mesh(X,Y,z);

a=5*j;
z=c.*(d-(X.^2)./(a^2)-(Y.^2)./(b^2)).^(1/2);
subplot(1,2,2);mesh(X,Y,z);