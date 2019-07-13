%г╤лвсО╬Д whileг╤лв
i=2;j=2;
while i<=100
    while j<=100
        if mod(i,j)==0
            break;
        end
        j=j+1;
    end
    if(i==j)
        disp(i)
    end
    i=i+1;
    j=2;
end