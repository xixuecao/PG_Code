clear;clc
P = initialize_population(); % typically random initialization is preferred
F = evaluate_population(P); % assigns fitness value to each individual
while ~termination_condition
    Ptemp = selection(P,F); % selects pairs of parents for the mating pool
    Pnew = crossover(Ptemp,pc); % crossover parents to create new individuals
    Pnew = mutation(Pnew,pm); % modify individuals using random changes
    P = Pnew; % replace old population by a new one
    F = evaluate_population(P); % assigns fitness value to each individual
end