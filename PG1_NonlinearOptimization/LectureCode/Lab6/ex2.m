clear;clc
N = [2 3 4 20];
out = {};
for k = 1:length(N)
    n = N(k);
    lb = 0*ones(1,n);
    ub = 1*ones(1,n);
    x0 = zeros(1,n);
    % options = optimset('Display','iter');
    [x, f] = fmincon(@fun2, x0, [],[],[],[],lb,ub,@out2);
    out{k} = x;
end
for j = 1:length(N)
    disp(['n = ',num2str(N(j))])
    disp(['x = ',num2str(out{j})])
    fprintf('\n')
end