function P = mutation(P,pm)
[N,L] = size(P);
x_max = max(P);
r = rand();
for j = 1:N %% Go through all genes in each individual for the
    for k = 1:L %% entire population
        if rand() < pm
            P(j,k) = (x_max(k)-P(j,k))*(2*abs(r-0.5))^1.2; %%
        end
    end
end