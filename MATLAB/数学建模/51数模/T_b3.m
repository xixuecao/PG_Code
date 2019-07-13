%clear all; clc ;
fitnessfcn=@f;  %适应度函数句柄 
nvars=5;      %变量个数 
A=[];b=[];    %线性不等式约束 
Aeq=[3586483 1829214 2392866 6727716 17201878];
beq=1586907;%线性等式约束  
lb=[-1 -1 -1 -1 -1];
ub=[1 1 1 1 1];
options=gaoptimset('paretoFraction',0.3,'populationsize',100,'generations', 200,'stallGenLimit',200,'TolFun',1e-100,'PlotFcns',@gaplotpareto); % 最优个体系数paretoFraction为0.3；种群大小populationsize为100，最大进化代数generations为200，  % 停止代数stallGenLimit为200， 适应度函数偏差TolFun设为1e-100，函数gaplotpareto：绘制Pareto前端  
[x,fval]=gamultiobj(fitnessfcn,nvars,A,b,Aeq,beq,lb,ub)