function y = PlotModel(chrom)
x = chrom(1);
y = chrom(2);
z = chrom(3);
figure(2)
scatter3(x, y, z, 'ko')
hold on
[X, Y] = meshgrid(-2:0.01:2);
Z =(1-X).^2 + 100*(Y - X.^2).^2;
mesh(X, Y, Z)
y=1;
