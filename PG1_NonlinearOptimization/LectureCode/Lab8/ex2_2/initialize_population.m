function P = initialize_population(N,L,lb,ub)
P = randi([lb ub], N, L);
subplot(121)
nor_path(P)
end