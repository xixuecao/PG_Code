[X,Y,Z]=sphere(50);        %������ά���� sphere(n)��nԽ������Խ�⻬

subplot(1,2,1);mesh(X,Y,Z);
title('mesh(X,Y,Z)');

subplot(1,2,2);surf(X,Y,Z);
title('surf(X,Y,Z)');