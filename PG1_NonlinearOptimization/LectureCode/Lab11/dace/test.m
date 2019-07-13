clear;clc
n=2;
N=50; % 20, 50, 100
X=lhsamp(N,n); % generate samples
lb=[-3 -3]; % lower bound
ub=[3 3]; % upper bound
for j=1:N
X(j,:)=lb+(ub-lb).*X(j,:); % denormalize sample points
Y(j)=feval('three_peaks',X(j,:)'); % evaluate fun at sample points
end
dmodel=dacefit(X,Y,@regpoly0,@corrgauss,[1 1],[0.01 0.01],[10 10]); % create model
xg=-3:0.2:3;
yg=-3:0.2:3;
[xi,yi]=meshgrid(xg,yg);
for j=1:length(xg)
for k=1:length(yg)
zi(k,j)=feval('three_peaks',[xg(j) yg(k)]'); % evaluate function f
vi(k,j)=predictor([xg(j) yg(k)],dmodel); % evaluate model
end
end
mesh(xi,yi,zi); % surface plot of the function f
view([-30 35]);
figure;
mesh(xi,yi,vi);% surface plot of the kriging model
hold on
for j=1:N
    plot3(X(j,1),X(j,2),Y(j),'ko','LineWidth',2,'MarkerSize',4); % plot of sample points
end
view([-30 35]);
hold off