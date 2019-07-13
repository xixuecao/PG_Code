clear;clc
A = [0.6 0.6 0.2;0.3 0.5 0.2;0.5 0.2 0.3];
B = [0.7 0.3;0.4 0.6;0.5 0.5];
p = [0.3 0.4 0.3;0.34 0.33 0.33;0.2 0.4 0.4]';
finalorder = [];
for i = 1:3
   
delta = p(:,i).*B(:,1);
index = [1;2;3];
flag = [1 2 1 2 1 1 2 2 2 1 1 2 1 2];
for i=1:14
    delta_matrix = delta .* A .* B(:,flag(i))';
    delta = max(delta_matrix)';
    idx = [];
    for i = 1:3
        temp = find(delta_matrix(:,i) == delta(i));
        idx = [idx;temp(1)];
    end
    index = [index,rem(idx,3)];
end
finalidx = find(delta == max(delta));
finalorder = [finalorder;index(finalidx,:)];
end
finalorder