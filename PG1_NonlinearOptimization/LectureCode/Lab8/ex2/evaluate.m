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
 