[X,Y]=meshgrid(-2:.2:2,-2:.2:2);%meshgrid������Զ�������������
Z=X.*exp(-X.^2-Y.^2);

subplot(1,2,1);mesh(X,Y,Z);     %��ά����ͼ
title('mesh(X,Y,Z)');

subplot(1,2,2);surf(X,Y,Z);     %��ά����ͼ
title('surf(X,Y,Z)');