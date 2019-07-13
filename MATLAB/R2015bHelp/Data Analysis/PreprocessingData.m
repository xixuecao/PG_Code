load count.dat
c3=count(:,3);
c3NaNCount=sum(isnan(c3))

bin_counts=hist(c3);% Histodram bin counts
N=max(bin_counts);% Maximum bin count
mu3=mean(c3);% Data mean
sigma3=std(c3);% Data standard deviation

hist(c3)% Plot histogram
hold on
plot([mu3 mu3],[0 N],'r','LineWidth',2)% Mean
X=repmat(mu3+(1:2)*sigma3,2,1);
Y=repmat([0;N],1,2);
plot(X,Y,'g','LineWidth',2)% Standard deviations
legend('Data','Mean','Stds')
hold off

outliers=(c3-mu3)>2*sigma3;
c3m=c3;% Copy c3 to c3m
c3m(outliers)=NaN;% Add NaN values

figure
hold on
plot(c3m,'o-')

span=3;% Size of the averaging window
window=ones(span,1)/span;
smoothed_c3m=convn(c3m,window,'same');% ¾í»ý

h=plot(smoothed_c3m,'ro-');
legend('Data','Smoothed Data')

smoothed2_c3m=filter(window,1,c3m)
% delete(h)
plot(smoothed2_c3m,'go-')
