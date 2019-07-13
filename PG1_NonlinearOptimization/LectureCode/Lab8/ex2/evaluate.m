%计算所有种群的适应度
function [f,p]=evaluate(s,dislist)
 
N=size(s,1);  %读取种群大小
f=zeros(N,1);
for i=1:N
   f(i)=CalDist(dislist,s(i,:));  %计算函数值，即适应度
end
f=1000./f'; %取距离倒数
%根据个体的适应度计算其被选择的概率
fsum=0;
for i=1:N
   fsum=fsum+f(i)^15;% 让适应度越好的个体被选择概率越高
end
ps=zeros(N,1);
for i=1:N
   ps(i)=f(i)^15/fsum;
end
 
%计算累积概率
p=zeros(N,1);
p(1)=ps(1);
for i=2:N
   p(i)=p(i-1)+ps(i);
end
p=p';
end
 