function svm = Train_svm(X,Y)
options = optimset; % Options�����������㷨��ѡ�����������
options.LargeScale = 'off'; % LargeScaleָ���ģ������off��ʾ�ڹ�ģ����ģʽ�ر�
options.Display = 'off'; % ����������ζ��û�����
C = 10;
[n l] = size(X);

H = (Y*Y').*(X*X');
f = -ones(n,1);
A = [];
b = [];
Aeq = Y';
beq = 0;
lb = zeros(n,1);
ub = C*ones(n,1);
a0 = zeros(n,1);
[a,fval,eXitflag,output,lambda]  = quadprog(H,f,A,b,Aeq,beq,lb,ub,a0,options);

epsilon = 1e-8;                     
sv_idx = find(abs(a)>epsilon); % a>0 ����ΪxΪ֧������     
svm.a = a(sv_idx);
svm.Xsv = X(sv_idx,:);
svm.Ysv = Y(sv_idx);
svm.svnum = length(sv_idx);
svm.label = sv_idx;
