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
 
%����λ������
function [DLn,P]=initialize_population(n)
P = randi([0 100], n, 2);
DLn=zeros(n,n);
for i=1:n
    for j=1:n
        DLn(i,j)=((P(i,1)-P(j,1))^2+(P(i,2)-P(j,2))^2)^0.5;
    end
end
subplot(121)
nor_path(P);
end
 
%����������Ⱥ����Ӧ��
function [f,p]=evaluate(s,dislist)
 
N=size(s,1);  %��ȡ��Ⱥ��С
f=zeros(N,1);
for i=1:N
   f(i)=CalDist(dislist,s(i,:));  %���㺯��ֵ������Ӧ��
end
f=1000./f'; %ȡ���뵹��
%���ݸ������Ӧ�ȼ����䱻ѡ��ĸ���
fsum=0;
for i=1:N
   fsum=fsum+f(i)^15;% ����Ӧ��Խ�õĸ��屻ѡ�����Խ��
end
ps=zeros(N,1);
for i=1:N
   ps(i)=f(i)^15/fsum;
end
 
%�����ۻ�����
p=zeros(N,1);
p(1)=ps(1);
for i=2:N
   p(i)=p(i-1)+ps(i);
end
p=p';
end
 
%"ѡ��"����
function seln=selection(p)
 
seln=zeros(2,1);
%����Ⱥ��ѡ���������壬��ò�Ҫ����ѡ��ͬһ������
for i=1:2
   r=rand;  %����һ�������
   prand=p-r;
   j=1;
   while prand(j)<0
       j=j+1;
   end
   seln(i)=j; %ѡ�и�������
   if i==2&&j==seln(i-1)    %%����ͬ����ѡһ��
       r=rand;  %����һ�������
       prand=p-r;
       j=1;
       while prand(j)<0
           j=j+1;
       end
   end
end
end
 
%"����"����
function scro=crossover(s,seln,pc)
 
bn=size(s,2);
scro(1,:)=s(seln(1),:);
scro(2,:)=s(seln(2),:);
if rand() < pc %���ݽ�����ʾ����Ƿ���н������
   c1=round(rand*(bn-2))+1;  %��[1,bn-1]��Χ���������һ������λ
   c2=round(rand*(bn-2))+1;
   chb1=min(c1,c2);
   chb2=max(c1,c2);
   middle=scro(1,chb1+1:chb2);
   scro(1,chb1+1:chb2)=scro(2,chb1+1:chb2);
   scro(2,chb1+1:chb2)=middle;
   for i=1:chb1 % �ҳ��ظ��ĳ��в��һ���ԭ���ĳ���
       while find(scro(1,chb1+1:chb2)==scro(1,i))
           zhi=find(scro(1,chb1+1:chb2)==scro(1,i));
           y=scro(2,chb1+zhi);
           scro(1,i)=y;
       end
       while find(scro(2,chb1+1:chb2)==scro(2,i))
           zhi=find(scro(2,chb1+1:chb2)==scro(2,i));
           y=scro(1,chb1+zhi);
           scro(2,i)=y;
       end
   end
   for i=chb2+1:bn
       while find(scro(1,1:chb2)==scro(1,i))
           zhi=logical(scro(1,1:chb2)==scro(1,i));
           y=scro(2,zhi);
           scro(1,i)=y;
       end
       while find(scro(2,1:chb2)==scro(2,i))
           zhi=logical(scro(2,1:chb2)==scro(2,i));
           y=scro(1,zhi);
           scro(2,i)=y;
       end
   end
end
end
 
%"����"����
function snnew=mutation(snew,pm)
 
bn=size(snew,2);
snnew=snew;
 
%���ݱ�����ʾ����Ƿ���б��������1���ǣ�0���
if rand() < pm
   c1=round(rand*(bn-2))+1;  %��[1,bn-1]��Χ���������һ������λ
   c2=round(rand*(bn-2))+1;
   chb1=min(c1,c2);
   chb2=max(c1,c2);
   x=snew(chb1+1:chb2);
   snnew(chb1+1:chb2)=fliplr(x);
end
end
 
%��Ӧ�Ⱥ���
function F=CalDist(dislist,s)
 
alldis = 0;
n = size(s,2);
for i = 1:(n-1)
    alldis = alldis + dislist(s(i),s(i+1));
end
alldis = alldis + dislist(s(n),s(1));
F = alldis;
end

%��ͼ
function drawTSP(Clist,BSF,bsf)
CityNum=size(Clist,1);
for i=1:CityNum-1
    plot([Clist(BSF(i),1),Clist(BSF(i+1),1)],[Clist(BSF(i),2),Clist(BSF(i+1),2)],'bo-');
    hold on;
end
plot([Clist(BSF(CityNum),1),Clist(BSF(1),1)],[Clist(BSF(CityNum),2),Clist(BSF(1),2)],'bo-');
xlabel(['Route Length = ',num2str(bsf)]) % ��ʾ����ܾ���
title([num2str(CityNum),' Cities GA-TSP']);
hold off;
end

function distance = nor_path(dots)
axis([0 100 0 100])
n = length(dots); % n����
plot(dots(:,1), dots(:,2), 'bo');
hold on
distance = 0; % �ܾ����ʱΪ0
for i = 1:n-1 % ��㵽�յ㻭n-1����
    x1 = dots(i,1);
    y1 = dots(i,2);
    x2 = dots(i+1,1);
    y2 = dots(i+1,2);
    distance = distance + norm([x1 y1] - [x2 y2]);
    plot([x1,x2],[y1,y2],'bo-');
%     plot(x2,y2,'ro');
%     line([x1 x2],[y1 y2]); % ��㻮��
end
x0 = dots(1,1);
y0 = dots(1,2);
xf = dots(end,1);
yf = dots(end,2);
line([x0 xf],[y0 yf]) % �����յ����ʼ��
distance = distance + norm([x0 y0] - [xf yf]);
xlabel(['Route Length = ',num2str(distance)]) % ��ʾ����ܾ���
title([num2str(n),' Cities TSP']);
end

