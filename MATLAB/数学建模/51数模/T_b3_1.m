
% ��Ŀ�����Ż� 
clear all; clc 
% ����Ŀ�꣬Ȩ�ذ�Ŀ�����ȷ����������ֵ 
%options = optimset('TolCon',1e-008)�� 
goal = [0 0 0]; 
weight = [0 0 0]; 
x0 = [0 0 0.01 0.05 0.01]; 
% ����Լ��������ϵ�� 
A=[]; B=[]; 
Aeq=[3586483 1829214 2392866 6727716 17201878];
Beq=1586907; 
lb=[-1 -1 -1 -1 -1];
ub=[1 1 1 1 1];
% ��� 
[x,fval] = fgoalattain(@ObjFun,x0,goal,weight,A,B,Aeq,Beq,lb,ub)  

