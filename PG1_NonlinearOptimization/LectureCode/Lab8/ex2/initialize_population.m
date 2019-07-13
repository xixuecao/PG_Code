%城市位置坐标
function [DLn,P]=initialize_population(n)
P = randi([0 100], n, 2);
DLn=zeros(n,n);
for i=1:n
    for j=1:n
        DLn(i,j)=((P(i,1)-P(j,1))^2+(P(i,2)-P(j,2))^2)^0.5;
    end
end
subplot(121)
nor_path(P);
end
 