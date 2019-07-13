%% Optimization-Based Sampling Algorithm
clear;clc
f = @ Auxiliary_functions;
N = 100;
%% 2D
n = 2;

forbid = [];dots = [];
subplot(121)
for i = 1:N
    dotx = (i-1)/N + rand()/N;
    doty = rand();
    while ismember(ceil(doty*N),forbid)
        doty = rand();
    end
    forbid = [forbid ceil(doty*N)];
    dots = [dots;[dotx,doty]];
    plot(dotx,doty,'bo')
    hold on
end
title(['Uniformity= ',num2str(Auxiliary_functions(dots))])
xlabel('Unoptimized')

subplot(122)
dots = rand(N,n);
dots = fmincon(f,dots,[],[],[],[],zeros(size(dots)),ones(size(dots)));
plot(dots(:,1),dots(:,2),'o')
title(['Uniformity= ',num2str(Auxiliary_functions(dots))])
xlabel('Optimized')
%% 3D
figure
n = 3;

forbidx = [];forbidy = [];dots = [];
subplot(121)
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
xlabel('Unoptimized')

subplot(122)
dots = rand(N,n);
dots = fmincon(f,dots,[],[],[],[],zeros(size(dots)),ones(size(dots)));
plot3(dots(:,1),dots(:,2),dots(:,3),'o')
title(['Uniformity= ',num2str(Auxiliary_functions(dots))])
xlabel('Optimized')