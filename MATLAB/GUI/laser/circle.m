function circle(a,L,b,diedai,handles)
global point 
global n
N=point;   
a=a*1000000;
L=L*1000000;
uu=ones(N,1);%初始化
u=ones(N,1);
k=2*pi/b;
m=1:N;
dr=a/(N-1);
da=2*pi/(N-1);
r=dr*(m-1);%离散化
theta=da*(m-1);
for n=1:diedai %进行迭代
    for j=1:N 
       u(j)=sum(exp(-i*k*L)*exp(-i*k*(r(j)^2+(r.^2)')/(2*L)).*r'.*(exp(i*k*r(j)*r'*cos(theta)/L)*da*ones(N,1)).*uu);
    end
    ma=max(u);%归一化
    uu=u/ma;
    axes(handles.axes1);
    mesh(r'*cos(theta),r'*sin(theta),abs(uu)*ones(N,1)')
    shading interp
    axes(handles.axes2);
    mesh(r'*cos(theta),r'*sin(theta),angle(uu)*ones(N,1)')
    set(handles.edit10,'string',num2str(n));%将迭代次数显示在面板上
    shading interp
end