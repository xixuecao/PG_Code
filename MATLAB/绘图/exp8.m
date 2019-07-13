
[X,Y,Z]=cylinder(3,30);     %绘制三维柱面 cylinder(R,n)中R为半径，n越大，柱面越光滑
figure;
surf(X,Y,Z);


[X,Y,Z]=cylinder([3,0],30); %绘制三维锥面 cylinder(R,n)中R为半径，n越大，柱面越光滑
figure;
surf(X,Y,Z);