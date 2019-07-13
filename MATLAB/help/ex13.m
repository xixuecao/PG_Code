clear;clc;
a=1:100;
c=[];
for N=1:100
   c=[c a(N)];
   disp(c)
end
%% 2
c=[];
a=1:100;
for N=1:100
   c=[c [num2str(a(N)) ',']];
end
c(end)=[]