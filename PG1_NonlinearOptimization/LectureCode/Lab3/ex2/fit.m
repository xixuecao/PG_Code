% �Ż�ǰ�ķ��þ��εĺ���
function [out_level,out_index,temp] = fit(low_level,rect)
x = rect(1);
y = rect(2);
A = low_level;
index = find(A == min(A));
[max_len, max_index] = con_size(index); % �ҵ���ʱˮƽ�߶��� ���������С�߶� �ĳ��Ⱥ�����
new_index = index(max_index(1):max_index(1)+max_len-1); % max_index���������С�߶ȿ����ж����ȡ����һ��
%% ��������С�߶ȵĳ� ���ڵ��� ��������ľ��ε�ˮƽ����
if max_len >= x
    out_index = new_index(1):new_index(1)+x-1; % ֻ��� ����ľ��εĳ��ȶ�Ӧ������
    temp = A(out_index);
    for k = 1:x
        temp(k) = temp(k) + y; % ���ˮƽ�߶�
    end
    X = [new_index(1)-1 x+new_index(1)-1 x+new_index(1)-1 new_index(1)-1];
    Y = [min(A) min(A) y+min(A) y+min(A)];
    fill(X,Y,'r'); % ������Ϊ��ɫ
    A(out_index) = temp;
%% ��������С�߶ȵĳ� С�� ��������ľ��ε�ˮƽ����
else 
    temp_A = A(index); % �ҵ����е���С�߶�
    A(index) = 1000; % ����Щ�߶ȸ�ֵΪ1000
    A(index) = min(A); % �ٴ�����С�߶ȣ��������ҵ���ԭ���߶���ڶ�С��ֵ������ԭ������С�߶ȸ�ֵΪ�ڶ�С�ĸ߶�
    low_level = A; % ���µ�ˮƽ�߶��ٴγ���
    [A,out_in,tmp] = fit(low_level,rect);
    out_index = out_in; % ������������ʱ��ÿ�ξ��γ��ȶ�Ӧ��������¼����
    temp = tmp;
    A(index) = temp_A; % ��ԭ������С�߶ȸ�ԭ�����ǻ������˾��ε�����Ҳ��ԭ
    A(out_in) = tmp; % �����һ�����ǰѾ��������Ӧ�ĸ߶���ߵ���Ӧ�߶�
end
out_level = A;

end

