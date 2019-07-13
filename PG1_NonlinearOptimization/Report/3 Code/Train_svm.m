function svm = Train_svm(X,Y)
options = optimset; % Options是用来控制算法的选项参数的向量
options.LargeScale = 'off'; % LargeScale指大规模搜索，off表示在规模搜索模式关闭
options.Display = 'off'; % 这样设置意味着没有输出
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
sv_idx = find(abs(a)>epsilon); % a>0 则认为x为支持向量     
svm.a = a(sv_idx);
svm.Xsv = X(sv_idx,:);
svm.Ysv = Y(sv_idx);
svm.svnum = length(sv_idx);
svm.label = sv_idx;
