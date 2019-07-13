% sentGen
% excel=struct('names',{'Lubo','Lishuai','Lihongru'},...
%     'adjectives',{'steady', 'active','interesting'});
excel={'Lubo','steady'; 'Lishuai','active';'Lihongru','interesting'};
r1=ceil(rand*3);r2=ceil(rand*3);
disp([excel{r1,1},' is ',excel{r2,2}]);

