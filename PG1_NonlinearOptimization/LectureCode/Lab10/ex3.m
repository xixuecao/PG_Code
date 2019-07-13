%% Latin Hypercube Sampling
%% 2D
clear;clc
N = 100;
n = 2;
dots = rand(N,n);
subplot(121)
plot(dots(:,1),dots(:,2),'o')
title(['Uniformity= ',num2str(Auxiliary_functions(dots))])
xlabel('Unoptimized')
grid on
forbid = [];dots = [];
subplot(122)
for i = 1:N
    dotx = (i-1)/N + rand()/N; % 限制x在一段范围内
    doty = rand(); % y可以随意取值
    while ismember(ceil(doty*N),forbid) % 如果y所在的行已经被其他点占据，则重新取值，直到这个y值单独占据一行
        doty = rand();
    end
    forbid = [forbid ceil(doty*N)]; % 将新的y值所在的行记为已使用
    dots = [dots;[dotx,doty]];
    plot(dotx,doty,'bo')
    hold on
end
title(['Uniformity= ',num2str(Auxiliary_functions(dots))])
xlabel('Optimized')
grid on
%% 3D
n = 3;
dots = rand(N,n);
figure
subplot(121)
plot3(dots(:,1),dots(:,2),dots(:,3),'o')
title(['Uniformity= ',num2str(Auxiliary_functions(dots))])
xlabel('Unoptimized')
grid on
forbidx = [];forbidy = [];dots = [];
subplot(122)
for z = 1:N
    dotz = (z-1)/N + rand()/N;
    dotx = rand();
    doty = rand();
    while ismember(ceil(dotx*N),forbidx)
        dotx = rand();
    end
    forbidx = [forbidx ceil(dotx*N)];
    while ismember(ceil(doty*N),forbidy)
        doty = rand();
    end
    forbidy = [forbidy ceil(doty*N)];
    dots = [dots;[dotx,doty,dotz]];
    plot3(dotx,doty,dotz,'bo')
    hold on
end
title(['Uniformity= ',num2str(Auxiliary_functions(dots))])
xlabel('Optimized')
grid on
