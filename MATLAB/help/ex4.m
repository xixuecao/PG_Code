% 如果有x1+x2+x3+x4+x5+x6=5
% x1,x2,x3,x4,x5,x6为0到5之间任意值，且满足约束条件
% 用matlab如何实现 求得x1,x2,x3,x4,x5,x6所有可能？
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

% 答案太多不现实