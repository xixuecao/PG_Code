function pm = adjust_mutation_rate(P,k,k_max,pm,pm0)
S = population_diversity(P); %% check population diversity
if k < k_max/2
    if S < 0.1
        pm = pm*1.3;
    else
        pm = pm/1.2;
    end
else
    pm = pm0*(2*(k_max-k)/k_max)^2;
end