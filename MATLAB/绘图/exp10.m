[X,Y,Z]=peaks(50);
subplot(1,2,1);
waterfall(X,Y,Z);
title('waterfall(X,X,Z)');
xlabel('X');ylabel('Y');zlabel('Z');


subplot(1,2,2);
contour3(X,Y,Z,12);%高度等级为12
title('contour3(X,X,Z)');
xlabel('X');ylabel('Y');zlabel('Z');



