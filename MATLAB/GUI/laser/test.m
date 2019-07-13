
lambda=8e-4;
f=80;
a=0.1;
x=linspace(-2,2,1000);
for i=1:1000
    u=(pi*a/lambda)*((x(i)/sqrt(x(i)^2+f^2)));
    I(i)=(sin(u)/u)^2;
end
NClevels=255;
Ir=NClevels*I;
figure;
colormap(gray);
subplot(2,1,1),image(x,I,Ir);
title('单缝衍射图像');
subplot(2,1,2),plot(x,I(:)/max(I));
title('单缝衍射强度曲线');
gtext({'(波长=600nm a=0.1mm f=200mm)'});