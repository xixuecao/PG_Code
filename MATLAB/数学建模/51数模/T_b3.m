%clear all; clc ;
fitnessfcn=@f;  %��Ӧ�Ⱥ������ 
nvars=5;      %�������� 
A=[];b=[];    %���Բ���ʽԼ�� 
Aeq=[3586483 1829214 2392866 6727716 17201878];
beq=1586907;%���Ե�ʽԼ��  
lb=[-1 -1 -1 -1 -1];
ub=[1 1 1 1 1];
options=gaoptimset('paretoFraction',0.3,'populationsize',100,'generations', 200,'stallGenLimit',200,'TolFun',1e-100,'PlotFcns',@gaplotpareto); % ���Ÿ���ϵ��paretoFractionΪ0.3����Ⱥ��СpopulationsizeΪ100������������generationsΪ200��  % ֹͣ����stallGenLimitΪ200�� ��Ӧ�Ⱥ���ƫ��TolFun��Ϊ1e-100������gaplotpareto������Paretoǰ��  
[x,fval]=gamultiobj(fitnessfcn,nvars,A,b,Aeq,beq,lb,ub)