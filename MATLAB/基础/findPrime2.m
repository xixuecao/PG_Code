function y=findPrime2(a)
y=[];
for i=2:a
    for j=2:a
        if mod(i,j)==0
            break;
        end
    end
    if i==j
       y=[y;i];
    end
end
end