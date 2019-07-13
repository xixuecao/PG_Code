function P = initialize_population(N,L,lb,ub)
P = zeros(N,L);
for i = 1:N
    P(i,:) = (lb-ub)*rand(1,L) - (lb-ub)/2;
end