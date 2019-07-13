blocks=find_system(bdroot,'BlockType','Scope');
for ii=1:length(blocks)
    set_param(blocks{ii},'Open','on')
end