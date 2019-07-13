%% Exercise 1: Genetic Algorithms with Floating-Point Representation
function [xbest,fbest] = fga(fun,N,lb,ub,pc,pm,L,k_max)
pm0 = pm;
P = initialize_population(N,L,lb,ub); %% P is the poluation
[F,xbest,fbest] = evaluate(fun,N,P); %% F is the fitness of the individuals in P
k = 0;
while k < k_max
%     Ptemp = selection(P,F);
%     P = crossover(Ptemp,pc);
    P = mutation(P,pm);
    [F,xbest,fbest] = evaluate(fun,xbest,P,fbest);
    pm = adjust_mutation_rate(P,k,k_max,pm,pm0);
    k = k+1;
end


