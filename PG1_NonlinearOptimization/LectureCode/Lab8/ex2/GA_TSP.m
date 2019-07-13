function GA_TSP
clear;clc
CityNum=40;
[dislist,P]=initialize_population(CityNum);
 
N=30; %初始种群大小
kmax=500;  %最大代数
pc=0.8; %交叉概率
pm=0.02; %变异概率
 
%产生初始种群
s=zeros(N,CityNum);
for i=1:N
    s(i,:)=randperm(CityNum);
end
[~,p]=evaluate(s,dislist);
 
k=1;
ymean=zeros(k,1);
ymax=zeros(k,1);
xmax=zeros(N,CityNum);
scnew=zeros(N,CityNum);
smnew=zeros(N,CityNum);
while k < kmax+1
   for j=1:2:N
      seln=selection(p);  %选择操作
      scro=crossover(s,seln,pc);  %交叉操作
      scnew(j,:)=scro(1,:);
      scnew(j+1,:)=scro(2,:);
      smnew(j,:)=mutation(scnew(j,:),pm);  %变异操作
      smnew(j+1,:)=mutation(scnew(j+1,:),pm);
   end
   s=smnew;  %产生了新的种群
   [f,p]=evaluate(s,dislist);  %计算新种群的适应度
   %记录当前代最好和平均的适应度
   [fmax,nmax]=max(f);
   ymean(k)=1000/mean(f);
   ymax(k)=1000/fmax;
   %记录当前代的最佳个体
   x=s(nmax,:);
   xmax(k,:)=x;
   k=k+1;
end
[min_ymax,index]=min(ymax);
subplot(122)
drawTSP(P,xmax(index,:),min_ymax);

figure;
plot(ymax,'r'); hold on;
plot(ymean,'b');grid;
title('搜索过程');
legend('最优解','平均解');
fprintf('遗传算法得到的最短距离:%.2f\n',min_ymax);
fprintf('遗传算法得到的最短路线');
disp(xmax(index,:));
end
 
