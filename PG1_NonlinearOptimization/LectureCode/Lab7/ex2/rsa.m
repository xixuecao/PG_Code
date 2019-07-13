function [x_best,y_best,fout,knum] = rsa(f,lb,ub)
x = lb:.01:ub;
y = lb:.01:ub;

x_best = x(randi(length(x)));
y_best = y(randi(length(x)));
f_best = f(x_best,y_best);
k = 0;k_max = 10000;
lambda = 1;
while true
    x_new = x(randi(length(x)));
    y_new = y(randi(length(x)));
    x_new = lambda*x_new + (1-lambda)*x_best;
    y_new = lambda*y_new + (1-lambda)*y_best;
    f_new = f(x_new,y_new);
    if ismember(1,[x_new y_new]<lb) || ismember(1,[x_new y_new]>ub)
        fout = f_best;
        knum = k;
        break;
    end
    if f_new < f_best
        delta = f_best - f_new;
        x_best = x_new;
        y_best = y_new;
        f_best = f_new;
        if delta < 1e-4
            fout = f_best;
            knum = k+1;
            break;
        end
    end
    lambda = (k_max-k)/k_max;
    k = k + 1;
end
end

