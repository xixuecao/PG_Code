clear;clc;
data = {[1,2.3743],[2,1.1497],[3,0.7317],[4,0.5556],[5,0.4675],[6,0.4157],[7,0.3807],[8,0.3546],[9,0.3337],[10,0.3164]};
X = [];Y = [];
for i = 1:length(data)    
    X = [X,data{i}(1)];
    Y = [Y,data{i}(2)];
end
plot(X,Y,'kx');
hold on
grid on
t = 1:10;

x0 = [1 1 1 1];
plot(t,fun3(x0,t,Y)+Y,'bo')
lb = 0*ones(1,length(x0));
ub = 10*ones(1,length(x0));
x = lsqnonlin(@(x)fun3(x,t,Y),x0,lb,ub);
plot(t,fun3(x,t,Y)+Y,'ro')
legend('Data','Approximation function (initial)',...
    'Approximation function (optimized)')
disp(['a=',num2str(x(1)),'  b=',num2str(x(2)),...
    '  c=',num2str(x(3)),'  d=',num2str(x(4))])