clear;clc
A = [0.9 0.05 0.05;0.45 0.1 0.45;0.45 0.45 0.1];
B = [0.5 0.5;0.75 0.25;0.25 0.75];
p = [1/3 1/3 1/3]';
delta1 = p.*B(:,1);
index1 = [1;2;3];
delta2_matrix = delta1 .* A .* B(:,1)';
delta2 = max(delta2_matrix)';

idx = find(delta2_matrix == delta2');
index2 = [index1,rem(idx,3)];
delta3_matrix = delta2 .* A .* B(:,2)';
delta3 = max(delta3_matrix)';

idx = find(delta3_matrix == delta3');
index3 = [index2,rem(idx,3)];
finalidx = find(delta3 == max(delta3))
order = index3(finalidx,:)