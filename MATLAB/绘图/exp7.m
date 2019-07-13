[X,Y,Z]=sphere(50);        %绘制三维球面 sphere(n)中n越大，球面越光滑

subplot(1,2,1);mesh(X,Y,Z);
title('mesh(X,Y,Z)');

subplot(1,2,2);surf(X,Y,Z);
title('surf(X,Y,Z)');