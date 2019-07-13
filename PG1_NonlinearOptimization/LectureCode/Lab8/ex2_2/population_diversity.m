function S = population_diversity(P)
[N,L] = size(P);
for j = 1:L
    for k = 1:N
        temp(k) = P(k,j);
    end
    R(j) = std(temp); %% standard deviation of jth gene
end
S = sum(R)/L;