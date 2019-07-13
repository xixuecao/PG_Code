%% Random Sampling
clear;clc
N = 100;
n = 2;
dots = rand(N,n);
subplot(121)
plot(dots(:,1),dots(:,2),'o')
title(['Uniformity= ',num2str(Auxiliary_functions(dots))])
xlabel('Unoptimized')
grid on
%% Stratified Random Sampling
subplot(122)
L = sqrt(N);
dots = rand(N,n)/L;
moved = zeros(N,n);
k = 1;
for i = 1:L
    for j = 1:L
        moved(k,:) = [(i-1)/L,(j-1)/L];
        k = k + 1;
    end
end
dots = dots + moved;
plot(dots(:,1),dots(:,2),'o')
title(['Uniformity= ',num2str(Auxiliary_functions(dots))])
xlabel('Optimized')
grid on