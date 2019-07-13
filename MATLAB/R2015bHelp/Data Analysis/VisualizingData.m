clear;clc;
load count.dat
%% 2-D Scatter Plots
c1 = count(:,1); % Data at intersection 1
c2 = count(:,2); % Data at intersection 2

figure
scatter(c1,c2,'filled')
xlabel('Intersection 1')
ylabel('Intersection 2')

C12 = cov([c1 c2])

R12 = corrcoef([c1 c2])

r12 = R12(1,2) % Correlation coefficient

r12sq = r12^2 % Coefficient of determination
%% 3-D Scatter Plots
figure
c3 = count(:,3); % Data at intersection 3
scatter3(c1,c2,c3,'filled')
xlabel('Intersection 1')
ylabel('Intersection 2')
zlabel('Intersection 3')

vars = eig(cov([c1 c2 c3]))

explained = max(vars)/sum(vars)
%% Scatter Plot Arrays
figure
plotmatrix(count)

%% Exploring Data in Graphs