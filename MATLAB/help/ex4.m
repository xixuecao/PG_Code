% �����x1+x2+x3+x4+x5+x6=5
% x1,x2,x3,x4,x5,x6Ϊ0��5֮������ֵ��������Լ������
% ��matlab���ʵ�� ���x1,x2,x3,x4,x5,x6���п��ܣ�
clear;clc;
x=[];
for x1=0:5
    for x2=0:5
        for x3=0:5
            for x4=0:5
                for x5=0:5
                    for x6=0:5
                        if (x1+x2+x3+x4+x5+x6==5)
                            x=[x;x1,x2,x3,x4,x5,x6];
                        else
                            break;
                        end
                    end
                end
            end
        end
    end
end

% ��̫�಻��ʵ