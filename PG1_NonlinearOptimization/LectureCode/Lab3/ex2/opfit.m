% �Ż���ķ��þ��εĺ���
function out_level = opfit(low_level,rects)
roy = [];
idx = [];
%% ɸѡ
% �����и߶�С��2����ת��Ȼ��Ѿ����г���С��2��������
for i = 1:length(rects)
    if rects(i,2) <= 2
        temp = rects(i,1);
        rects(i,1) = rects(i,2);
        rects(i,2) = temp;
    end
    if rects(i,1) <= 2
        roy = [roy;rects(i,:)];
        idx = [idx i];
    end
end
%% ����
rects(idx,:) = []; % �ѳ���С��2�ľ���ȥ��Ȼ���ŵ���
a = rects;
b=a(:,1);
[c,pos]=sort(b);%posΪ�������±�,cΪ��һ�е�������; 
p = [c,pos];
X=eye(length(p)); 
X=rot90(X); 
p=X*p;
a(:,2)=a(p(:,2),2);%�ڶ��а��յ�һ��������±��Ӧ 
a(:,1)=p(:,1);

aa = roy; % ����С��2�ľ���������
b=aa(:,1);
[c,pos]=sort(b);%posΪ�������±�,cΪ��һ�е�������; 
aa(:,2)=aa(pos,2);%�ڶ��а��յ�һ��������±��Ӧ 
aa(:,1)=c;
%% �������
rects = [a(1:round(length(a)/2),:);aa;a(round(length(a)/2)+1:end,:)]; % �ѳ���С��2�ľ��η��ڵ���ľ����м�
for i = 1:length(rects)
    out_level = fit(low_level,rects(i,:));
    low_level = out_level;
end
end

