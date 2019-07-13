clear;tic
D=arrayfun(@(i)sin(i*pi/30),1:60);
P=repmat(D,300,5);
imshow(P)
toc

%%
clear;tic
P=zeros(300);
for i=1:300
    P(:,i)=sin(i*pi/30);
end
imshow(P)
toc