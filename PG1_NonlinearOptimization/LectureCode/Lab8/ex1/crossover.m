function R = crossover(P,pc)
[N,L] = size(P);
R = [];
for j = 1:N/2
    if rand() < pc
        c = rand(1,L); %% P{2*j} and P(2*j-1} are a pair of parents
        for k = 1:L
            R(j,k) = P(j,:)*[c(k),(1-c(k))]';
        end
    else
        R(j,:) = P(2*j,:);
    end
end