bdclose all;%close all models
threshold=get(handles.edit1,'string');%get data from GUI
up_out=get(handles.edit2,'string');
down_out=get(handles.edit3,'string');
rel=get(handles.popupmenul,'Value');
mdl_name='switch_section';
mdl_handle=new_system(mdl_name);
open_system(mdl_name);%create and open a new model file
add_block('simulink/Signal Routing/Switch',[mdl_name,'/Switch']);
add_block('simulink/Commonly Used Blocks/In1',[mdl_name,'/In1'],'Position',[35 213 65 227]);
add_block('simulink/Commonly Used Blocks/Out1',[mdl_name,'/Out1'],'Position',[345 213 375 227]);
add_block('simulink/Commonly Used Blocks/Constant',[mdl_name,'/Constant'],'Position',[125 150 155 180]);
add_block('simulink/Commonly Used Blocks/Constant',[mdl_name,'/Constant1'],'Position',[125 265 155 295]);
if rel==2
    criterial='u2>Threshold';
elseif rel==1
    criterial='u2>=Threshold';
else
    criterial='u2~=0';
end
set_param([mdl_name,'/Switch'],'Criterial',criterial,'Threshold',threshold);
set_param([mdl_name,'/Constant'],'Value',up_out);
set_param([mdl_name,'/Constant1'],'Value',down_out);
autorouting=get(handles.checkbox1,'value');
if isequal(autorouting,0)%whether auto routing
    add_line(mdl_name,'In1/1','Switch/2');%connect line from/to port number
    add_line(mdl_name,'Switch/1','Out1/1');
    add_line(mdl_name,'Constant/1','Switch/1');
    add_line(mdl_name,'Constant1/1','Switch/3');
else
    add_line(mdl_name,'In1/1','Switch/2','autorouting','on');
    add_line(mdl_name,'Switch/1','Out1/1','autorouting','on');
    add_line(mdl_name,'Constant/1','Switch/1','autorouting','on');
    add_line(mdl_name,'Constant1/1','Switch/3','autorouting','on');
end