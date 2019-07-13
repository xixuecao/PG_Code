function P = mutation(P,pm)
N = length(P);

for j = 1:N %% Go through all genes in each individual for the
    if rand() < pm
        r = randi(N);
        temp = P(j,:);
        P(j,:) = P(r,:); %% flip the kth binary number
        P(r,:) = temp;
    end
end