%���ú��������� disp��ʾ ����������ʵ��Ŀ
function findPrime1(a)
for i=2:a
    for j=2:a
        if mod(i,j)==0
            break;
        end
    end
    if i==j
        disp(i)
    end
end
end