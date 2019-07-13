clear;clc;

p=perms(1:4);

% generates the 4! = 24 peermutations of 1:4. The kth permutation is the
% row vector p(k,:). Then

A=magic(4);
M=zeros(4,4,2);

for k=1:24
    M(:,:,k)=A(:,p(k,:))
end

%store the sequence of 24 magic squares in a three-dimensional array, M.The
%size of M is

size(M)

sum(M,1)
sum(M,2)
S = sum(M,3)