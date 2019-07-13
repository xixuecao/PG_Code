clear;clc;
% �����޸�Configuration Parameters -- save to workspace -- Format:Array
%% param_struct1
param_struct1.SaveState      = 'on';
param_struct1.StateSaveName  = 'xout1';
param_struct1.SaveOutput     = 'on';
param_struct1.OutputSaveName = 'yout1';
param_struct1.SolverType     = 'Fixed-step';
param_struct1.Solver         = 'FixedStepDiscrete';
param_struct1.FixedStep      ='0.01';
sim_out1=sim('m_control_03',param_struct1);
%% paran_struct2
param_struct2 = param_struct1;
param_struct2.FixedStep      = '2'; 
param_struct2.OutputSaveName = 'yout2';
sim_out2=sim('m_control_03',param_struct2);
%% plot
t1=get(sim_out1,'tout');
t2=get(sim_out2,'tout');
y1=get(sim_out1,'yout1');
y2=get(sim_out2,'yout2');
figure;

subplot(211);
plot(t1,y1);
grid on;
xlabel('time/s');
ylabel('yout1');
subplot(212);
plot(t2,y2);
grid on;
xlabel('time/s');
ylabel('yout2');