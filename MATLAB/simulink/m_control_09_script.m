new_system('m_control_08');open_system('m_control_08');
add_block('simulink/Sources/In1','m_control_08/In1');
add_block('simulink/Sinks/Out1','m_control_08/Out1');
add_line('m_control_08','In1/1','Out1/1','autorouting','on');