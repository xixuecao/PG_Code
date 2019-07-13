clear;clc
l1 = 0;u1 = 1;
l2 = 0;u2 = 1;
N = 50;
%% 2D
n = 2;
dots = rand(N,n);
plot(dots(:,1),dots(:,2),'o')
title(['Uniformity= ',num2str(Auxiliary_functions(dots))])
%% 3<=D
n = 3;
dots = rand(N,n);
% figure
% plot3(dots(:,1),dots(:,2),dots(:,3),'o')
% grid
% Auxiliary_functions(dots)
or = nchoosek(1:n,2);
k = size(or,1);
figure
hold on
for i = 1:k
    subplot(1,k,i);
    plot(dots(:,or(i,1)),dots(:,or(i,2)),'o')
    
    xlabel(['x=',num2str(or(i,1)),' y=',num2str(or(i,2))])
    title([' Uniformity= ',num2str(Auxiliary_functions(dots(:,or(i,:))))])
end


