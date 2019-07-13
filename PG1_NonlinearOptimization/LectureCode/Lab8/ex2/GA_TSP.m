function GA_TSP
clear;clc
CityNum=40;
[dislist,P]=initialize_population(CityNum);
 
N=30; %��ʼ��Ⱥ��С
kmax=500;  %������
pc=0.8; %�������
pm=0.02; %�������
 
%������ʼ��Ⱥ
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
      seln=selection(p);  %ѡ�����
      scro=crossover(s,seln,pc);  %�������
      scnew(j,:)=scro(1,:);
      scnew(j+1,:)=scro(2,:);
      smnew(j,:)=mutation(scnew(j,:),pm);  %�������
      smnew(j+1,:)=mutation(scnew(j+1,:),pm);
   end
   s=smnew;  %�������µ���Ⱥ
   [f,p]=evaluate(s,dislist);  %��������Ⱥ����Ӧ��
   %��¼��ǰ����ú�ƽ������Ӧ��
   [fmax,nmax]=max(f);
   ymean(k)=1000/mean(f);
   ymax(k)=1000/fmax;
   %��¼��ǰ������Ѹ���
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
title('��������');
legend('���Ž�','ƽ����');
fprintf('�Ŵ��㷨�õ�����̾���:%.2f\n',min_ymax);
fprintf('�Ŵ��㷨�õ������·��');
disp(xmax(index,:));
end
 
