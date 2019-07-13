clear;clc;
global R;R=10;                       %驱动点运动半径
global omega;omega=pi/3;             %驱动点运动半径
global l;l=15;
global m;m=0.05;
global g;g=9.8;
t=linspace(0,100,1001);
j=0;

figure
title('The diagram of Lagging Pendulum');
axis([-30 30 -30 30 -10 10]);
grid on
hold on
plot3([0;0],[0;0],[10;-7],'k-.')

for k=0:0.5:10
    R=10+k;
    j=j+11;
    x0=[0.1;0.1];
    options = optimoptions('fsolve'); 
    [x,fval] = fsolve(@myfun,x0,options);
    r=x(1);
    theta=x(2);
    th=theta./(2*pi).*180;

    x0=R.*sin(omega.*t);
    y0=R.*cos(omega.*t);
    z0=0.*t+8;

    x1=r.*sin(omega.*t+pi);
    y1=r.*cos(omega.*t+pi);
    z1=z0-l*sin(theta)+0.*t;


    h12=plot3([x0(1);x1(1)],[y0(1);y1(1)],[y0(1);y1(1)],'b-o','LineWidth',1.5);%画杆并取句柄


    for i=j:j+10
        set(h12,'XData',[x0(i);x1(i)],'YData',[y0(i);y1(i)],'Zdata',[z0(i);z1(i)]);
        plot3([x0(i);x0(i+1)],[y0(i);y0(i+1)],[z0(i);z0(i+1)],'g')
        plot3([x1(i);x1(i+1)],[y1(i);y1(i+1)],[z1(i);z1(i+1)],'r')

        drawnow
    end
end
