function fun4(N)

for k = 1:length(N)
    n = N(k);
x0 = ones(1,n)/n;
aeq = ones(1,n);
beq = 1;
lb = zeros(1,n);
x = fminimax(@black_box,x0,[],[],aeq,beq,lb,[]);
%%
subplot(2,length(N),k)
plot((1:n)-0.01,x0,'ko')
grid on
hold on
plot((1:n)+0.01,x,'ro')
for i = 1:n
    line([i,i]-0.01,[0 x0(i)],'color','k')
    line([i,i]+0.01,[0 x(i)],'color','r')
end
xlim([1-0.01 n+0.01])
title('Function Arguments')
%%
subplot(2,length(N),k+length(N))
y0 = black_box(x0);
y = black_box(x);
plot((1:n)-0.01,y0,'ko')
grid on
hold on
plot((1:n)+0.01,y,'ro')
for i = 1:n
    line([i,i]-0.01,[0 y0(i)],'color','k')
    line([i,i]+0.01,[0 y(i)],'color','r')
end
xlim([1-0.01 n+0.01])
title('Function Values')
end


end

