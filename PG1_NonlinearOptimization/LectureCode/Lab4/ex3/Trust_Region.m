function[x, iter] = Trust_Region(f, var, x0, r0, miu, yita, eps)
% Ŀ�꺯��:                       f
% �Ա�������:                     var
% ��ʼ��:                         x0
% ��ʼ������뾶:                 r0
% ��ʼ����:                       miu
% ��ʼ����:                       yita
% ����:                          eps
% Ŀ�꺯��ȡ��Сֵ���Ա���ֵ:      x
% ��������:                      iter
tol = 1;
r = r0;
x = x0;
iter = 1; % ��������
while tol > eps   
    jacf = jacobian(f, var); % �ſɱȾ���       
    fx = double(subs(f, var, x)); % ����Ŀ�꺯��ֵ
    v = subs(jacf, var, x); % �����ſ˱Ⱦ���ֵ
    tol = double(norm(v));  
    M1 = double(transpose(v)); % ���ι滮 �е�һ�������
    lb = -r * ones(length(var), 1); % rΪ������뾶���Ա����½�Լ��
    ub = r * ones(length(var), 1); % �Ա����Ͻ�Լ��
    [y, fy] = quadprog([], M1, [], [], [], [], lb, ub); % �����ι滮
    fx_n = double(subs(f, var, x + y)); % ���¼���Ŀ�꺯��ֵ
    p = (fx - fx_n) / (-fy); % ����Ŀ�꺯��ʵ���½���Ԥ���½�֮��
    if p <= miu % Ŀ�꺯��ʵ���½�������
        r = 0.5 * r;    
    else % Ŀ�꺯��ֵ�½�����   
        x = x + y; % ���²���, ����������뾶
        if p >= yita % ��� p > yita
            r = 2 * r;
        end
    end
    iter = iter + 1;
end
end
