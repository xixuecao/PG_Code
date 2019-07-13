set_param('m_control_05','SimulationCommand','start');%start simulation
scope_h=find_system('m_control_05','findall','on','Blocktype','Scope');
num_scope=length(scope_h);%get all handles of scope
for ii =1:num_scope
    set(scope_h(ii),'Open','on');%set Scope Open its axis
end