clear;clc
fitness = @simpleMultiObjective;
nvar = 1;
[x, fval] = gamultiobj(fitness, nvar);
%% 
x0 = -10:0.5:10;  
f1 = (x0+2).^2 - 10;
f2 = (x0-2).^2 + 20;
figure;hold on
plot(x0, f1, x0, f2)
grid;
xlabel('x')
ylabel('f')
%%
plot(x, fval(:,1),'x')
plot(x, fval(:,2),'o')

figure
plot(fval(:,1),fval(:,2),'o');
xlabel('f1')
ylabel('f2')
grid