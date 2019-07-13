function [theta J_history] = GradDesc(X,y,theta,m,alpha,iterations)

J_history=[];
theta_p=[];

for iter=1:iterations
    sum=0;
    for i=1:m
        sum=sum+(theta'*X(i,:)'-y(i))*X(i,:);
    end
    theta=theta-(alpha/m*sum)';
    J_history(iter)=CompCost(X,y,theta,m);
    if iter > 1 && J_history(iter)<=min(J_history)
        theta_p=theta;
    end   
end
theta=theta_p;
end

