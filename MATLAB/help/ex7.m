clear;clc;
fg1=zeros(1,684);
for i=1:684;
    if sum(fg1(:,i))==237
        fg1(1,i)=1;
    else sum(fg1(:,i))<237;
        fg1(1,i)=0;
    end
end

for i=1:684;
    
    if fg1(i)+fg1(i+1)==1;
        fg2=i
    end
    if i==683;
        break
    end
end