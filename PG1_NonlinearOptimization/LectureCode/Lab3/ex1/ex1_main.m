clear;clc
dots = [randi([0 100], 40, 1), randi([0 100], 40, 1)];
subplot(1,2,1)
nor_path(dots) % ��ͨ����
subplot(1,2,2)
min_path(dots) % �Ż�����