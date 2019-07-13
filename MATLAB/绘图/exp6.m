[X,Y]=meshgrid(-2:.2:2,-2:.2:2);%meshgrid命令会自动生成网格坐标
Z=X.*exp(-X.^2-Y.^2);

subplot(1,3,1);mesh(X,Y,Z);     
title('mesh(X,Y,Z)');

subplot(1,3,2);meshc(X,Y,Z);    %绘制等高线     
title('meshc(X,Y,Z)');

subplot(1,3,3);meshz(X,Y,Z);    %绘制     
title('meshz(X,Y,Z)');