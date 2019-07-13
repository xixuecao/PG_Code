%Ç¶Ì×Óï¾ä forÇ¶Ì×
for i=2:100
    for j=2:100
        if mod(i,j)==0
            break;
        end
    end
    if i==j
        disp(i)
    end
end