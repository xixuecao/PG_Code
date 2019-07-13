clear all
x=0:0.02:0.8; 
y=x; 
[CData.xi,CData.yi]=meshgrid(x,y); 
for j=1:length(x)
    for k=1:length(y)
        CData.zi(j,k)=two_peaks([x(j),y(k)]);
    end
end
x0=[0.1 0.1]';
B.lb=[0 0]';
B.ub=[0.8 0.8]'; 
[x_opt,f_opt]=rnd_search('two_peaks',x0,B,CData,80,1e-5);
fprintf('Final solution: %f %f\n',x_opt(1),x_opt(2));
disp(['Function value: ',num2str(f_opt)]);