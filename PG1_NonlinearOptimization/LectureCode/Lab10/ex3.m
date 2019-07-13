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
    dotx = (i-1)/N + rand()/N; % ����x��һ�η�Χ��
    doty = rand(); % y��������ȡֵ
    while ismember(ceil(doty*N),forbid) % ���y���ڵ����Ѿ���������ռ�ݣ�������ȡֵ��ֱ�����yֵ����ռ��һ��
        doty = rand();
    end
    forbid = [forbid ceil(doty*N)]; % ���µ�yֵ���ڵ��м�Ϊ��ʹ��
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
