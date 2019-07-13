 x=zeros(10000,1);
 for n=2:10000
     if rand<0.5
         x(n)=x(n-1)-1;
     else
         x(n)=x(n-1)+1;
     end
 end
 figure;
 hist(x,50)
     
     
     
     
     