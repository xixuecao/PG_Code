%ÊÊÓ¦¶Èº¯Êý
function F=CalDist(dislist,s)
 
alldis = 0;
n = size(s,2);
for i = 1:(n-1)
    alldis = alldis + dislist(s(i),s(i+1));
end
alldis = alldis + dislist(s(n),s(1));
F = alldis;
end