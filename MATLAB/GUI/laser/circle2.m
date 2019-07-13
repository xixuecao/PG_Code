function circle2(a,L,b,handles)
global point
global n
N=point;
a=a*1000000;
L=L*1000000;
uu=ones(N,1);
u=ones(N,1);
k=2*pi/b;
m=1:N;
dr=a/(N-1);
da=2*pi/(N-1);
r=dr*(m-1);
theta=da*(m-1);
min=0.005;
diedai=300;
for n=1:diedai 
    for j=1:N
        u(j)=sum(exp(-i*k*L)*exp(-i*k*(r(j)^2+(r.^2)')/(2*L)).*r'.*(exp(i*k*r(j)*r'*cos(theta)/L)*da*ones(N,1)).*uu);
    end
    ma=max(u);%归一化
    u=u/ma;
    if(abs(uu-u)<min*ones(N,1))%自再现判据
        break
    end
    uu=u;
    axes(handles.axes1);
    mesh(r'*cos(theta),r'*sin(theta),abs(uu)*ones(N,1)')
    shading interp
    axes(handles.axes2);
    mesh(r'*cos(theta),r'*sin(theta),angle(uu)*ones(N,1)')
    shading interp
    set(handles.edit10,'string',num2str(n));%迭代次数显示到面板
end