clear;clc;
% HelloWorld.m
% my first hello world program in MATLAB

load('startTime.mat');
disp('Hello World!');
disp(['I am going to learn MATLAB!',startString]);

secPerDay=24*3600;
tau=1.5*secPerDay;
endOfClass=5*secPerDay;

tVec=linspace(0,endOfClass,10000);
knowledgeAtEnd=1-exp(-endOfClass/tau);
knowledgeVec=1-exp(-tVec/tau);
disp(['At the end of 6.094, I will know '...
    num2str(knowledgeAtEnd) '% of MATLAB'])

[Val, Ind]=min(abs(knowledgeVec-0.5));
halfTime=tVec(Ind);
disp(['I will know half of MATLAB after '...
   num2str(halfTime/secPerDay) ' days'])

figure
plot(tVec/secPerDay,knowledgeVec,[0 endOfClass/secPerDay],[0.5,0.5]);
grid on
