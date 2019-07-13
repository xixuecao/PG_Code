function nor_path(dots)
%% �������ݵ�

axis([0 100 0 100])
n = length(dots); % n����
plot(dots(:,1), dots(:,2), 'bo');
hold on
distance = 0; % �ܾ����ʱΪ0
%% ���ӵ�
for i = 1:n-1 % ��㵽�յ㻭n-1����
    x1 = dots(i,1);
    y1 = dots(i,2);
    x2 = dots(i+1,1);
    y2 = dots(i+1,2);
    distance = distance + norm([x1 y1] - [x2 y2]);
    plot(x1,y1,'ro');
    plot(x2,y2,'ro');
    line([x1 x2],[y1 y2]); % ��㻮��
end
%% ���һ����
x0 = dots(1,1);
y0 = dots(1,2);
x40 = dots(40,1);
y40 = dots(40,2);
line([x0 x40],[y0 y40]) % �����յ����ʼ��
xlabel(['Route Length = ',num2str(distance)]) % ��ʾ����ܾ���
end

