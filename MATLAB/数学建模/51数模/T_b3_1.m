
% 多目标最优化 
clear all; clc 
% 给定目标，权重按目标比例确定，给出初值 
%options = optimset('TolCon',1e-008)； 
goal = [0 0 0]; 
weight = [0 0 0]; 
x0 = [0 0 0.01 0.05 0.01]; 
% 给出约束条件的系数 
A=[]; B=[]; 
Aeq=[3586483 1829214 2392866 6727716 17201878];
Beq=1586907; 
lb=[-1 -1 -1 -1 -1];
ub=[1 1 1 1 1];
% 求解 
[x,fval] = fgoalattain(@ObjFun,x0,goal,weight,A,B,Aeq,Beq,lb,ub)  

