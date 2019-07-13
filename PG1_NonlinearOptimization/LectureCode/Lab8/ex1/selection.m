function R = selection(P,F)
[N,L] = size(P);
R = zeros(2*N,L);
for j = 1:2*N
    c = ceil(N*rand(1,2)); %% random values [c1 c2] ci=1~N
    if F(c(1)) < F(c(2))
        R(j,:) = P(c(1),:);
    else
        R(j,:) = P(c(2),:);
    end
end