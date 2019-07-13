clear;clc
N = [3 5 10];
for k = 1:length(N)
    n = N(k);
x0 = zeros(n,1);
optionsa = optimset('TolX',1e-8,'TolFun',1e-8,'OutputFcn',@out1);
[xa,fa,~,outputa] = fminunc(@fun1,x0,optionsa);
% disp(['final result: [',num2str(xa'),']',]);
% disp(['final function value: ',num2str(fa)]);

optionsb = optimset('TolX',1e-8,'TolFun',1e-8,'MaxIter',5000,'MaxFunEvals',1000000,'OutputFcn',@out1);
[xb,fb,~,outputb] = fminsearch(@fun1,x0,optionsb);
% disp(['final result: [',num2str(xb'),']',]);
% disp(['final function value: ',num2str(fb)]);

disp(['number of fminunc : ',num2str(outputa.iterations)]);
disp(['number of fminsearch: ',num2str(outputb.iterations)]);
end