[X,Y]=meshgrid(-2:.2:2,-2:.2:2);%meshgrid命令会自动生成网格坐标
Z=X.*exp(-X.^2-Y.^2);

subplot(1,2,1);mesh(X,Y,Z);     %三维网格图
title('mesh(X,Y,Z)');

subplot(1,2,2);surf(X,Y,Z);     %三维曲面图
title('surf(X,Y,Z)');