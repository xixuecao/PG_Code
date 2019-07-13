function min_path(dots)
%% �������ݵ�
axis([0 100 0 100])
n = length(dots); % n����
plot(dots(:,1), dots(:,2), 'bo');
hold on
%% ���㲻ͬ��֮����� ����������ϵķ�ʽ����¾���
distance = 0; % �ܾ����ʱΪ0
D = pdist(dots); % ���㲻ͬ��֮�����
dots_D = [nchoosek(1:n,2) D']; % ������ϵõ��¾��� ex:[1 25 3.677] ��һ����͵�25����֮�����Ϊ3.677
%% ��ÿ�����ҵ���������ĵ� ���� ����ȥ����Щ���� ͬʱ��"ͷ"�ƶ�����һ���� 
temp = 1; % "ͷ"����Ϊ��һ����x1 = dots(1,1) y1 = dots(1,2)
for i = 1:n-1 % ��㵽�յ㻭n-1����
    index = find(dots_D(:,1) == temp | dots_D(:,2) == temp); 
    temp_dots_D = dots_D(index,:); % �ҵ����еľ�"ͷ"��ľ��� ����������ĵ�ͱ�ĵ㵽��
    mind = min(temp_dots_D(:,3)); % ����Щ�������ҵ���Сֵ
    id = find(temp_dots_D(:,3)==mind); % �õ���Сֵ������ �������㵽"ͷ"����С�������Ϸ�ʽ ������
    k = id(1); % �п����ж���㵽"ͷ"����붼��С ֻȡһ��
    x1 = dots(temp_dots_D(k,1),1);
    y1 = dots(temp_dots_D(k,1),2);
    x2 = dots(temp_dots_D(k,2),1);
    y2 = dots(temp_dots_D(k,2),2);
    %{
    ����k�������� temp_dots_D(k,:)�õ�����[1 20 3.02] 
    ����һ���㵽�ڶ�ʮ����ľ���Ϊ3.02 ����3.02�����������㵽��һ������С�ľ���
    %}
    distance = distance + norm([x1 y1] - [x2 y2]);
    plot(x1,y1,'ro');
    plot(x2,y2,'ro');
    line([x1 x2],[y1 y2]); % ��㻮��
    if temp_dots_D(k,1) == temp
        temp = temp_dots_D(k,2);
    elseif temp_dots_D(k,2) == temp
        temp = temp_dots_D(k,1);
    end
    %{
    ����ж������Ϊ�˴���"ͷ"��,����[1 20 3.02]
    ������ڵ�,�Ѿ��������˵�"ͷ"���ǵ�һ����,��"ͷ"�㴫Ϊ�ڶ�ʮ����
    ���"ͷ"���ǵڶ�ʮ����,��"ͷ"�㴫Ϊ��һ����.
    %}
    dots_D(index,:) = []; % ����Ѿ��������˵�"ͷ"�����о�����Ϣ��������������ĵ㻹�Ǳ�ĵ㵽��
end
%% ���һ����
x0 = dots(1,1);
y0 = dots(1,2);
x40 = dots(temp,1);
y40 = dots(temp,2);
line([x0 x40],[y0 y40]) % �����յ����ʼ��
xlabel(['Route Length = ',num2str(distance)]) % ��ʾ����ܾ���
end

