function E = Auxiliary_functions(dots)
N = size(dots);
E = 0;
for i = 1:N
    for j = i+1:N
        E = E + 1/(norm(dots(i,:)-dots(j,:)))^2;
    end
end

end

