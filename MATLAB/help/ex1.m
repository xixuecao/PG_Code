
clear;clc;
m=[];
for a=1:19;
    for b=1:19;
        c=20-a-b;
        if c<=0;
            break
        else
            m=[m,100/a+63/b+34/c];
        end
    end
end
min(m)