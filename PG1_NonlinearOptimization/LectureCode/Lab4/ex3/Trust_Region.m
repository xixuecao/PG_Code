function[x, iter] = Trust_Region(f, var, x0, r0, miu, yita, eps)
% 目标函数:                       f
% 自变量向量:                     var
% 初始点:                         x0
% 初始信赖域半径:                 r0
% 初始参数:                       miu
% 初始参数:                       yita
% 精度:                          eps
% 目标函数取最小值的自变量值:      x
% 迭代次数:                      iter
tol = 1;
r = r0;
x = x0;
iter = 1; % 迭代次数
while tol > eps   
    jacf = jacobian(f, var); % 雅可比矩阵       
    fx = double(subs(f, var, x)); % 计算目标函数值
    v = subs(jacf, var, x); % 计算雅克比矩阵值
    tol = double(norm(v));  
    M1 = double(transpose(v)); % 二次规划 中的一次项矩阵
    lb = -r * ones(length(var), 1); % r为信赖域半径，自变量下界约束
    ub = r * ones(length(var), 1); % 自变量上界约束
    [y, fy] = quadprog([], M1, [], [], [], [], lb, ub); % 求解二次规划
    fx_n = double(subs(f, var, x + y)); % 重新计算目标函数值
    p = (fx - fx_n) / (-fy); % 计算目标函数实际下降与预测下降之比
    if p <= miu % 目标函数实际下降不明显
        r = 0.5 * r;    
    else % 目标函数值下降明显   
        x = x + y; % 更新参数, 扩大信赖域半径
        if p >= yita % 如果 p > yita
            r = 2 * r;
        end
    end
    iter = iter + 1;
end
end
