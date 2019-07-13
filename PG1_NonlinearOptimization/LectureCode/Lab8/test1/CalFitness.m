function fitness = CalFitness(chrom, N, N_chrom)
fitness = zeros(N, 1);
%��ʼ������Ӧ��
for i = 1:N
    x = chrom(i, 1);
    y = chrom(i, 2);
    fitness(i) = (1-x)^2 + 100*(y - x^2)^2;
end
