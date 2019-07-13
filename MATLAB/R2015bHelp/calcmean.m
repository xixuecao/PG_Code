clear;clc;
nsamples=5;
npoints=50;

for k = 1:nsamples
    %iterationString=['Iteration #',num2str(k)];
    display(['Iteration #',num2str(k)])
    currentData = rand(npoints,1);
    sampleMean(k) = mean(currentData)
end
overallMean = mean(sampleMean)

if overallMean<0.49
    disp('Mean is less than expected')
elseif overallMean>.51
    disp('Mean is greater than expected')
else
    disp('Mean is within than expected')
end