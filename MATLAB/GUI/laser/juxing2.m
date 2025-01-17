function juxing2(bochang,a,b,L,handles)
global n
global point
k=2*pi/bochang;
a=a*1000000;
b=b*1000000;
deltax=2*a/point;
min=0.01;
L=L*1000000;
xx=-a:deltax:a;
yy=-b:deltax:b;
nx=length(xx);
ny=length(yy);
N=800; 
ux=ones(1,nx);
uy=ones(1,ny);
u_last=ones(ny,nx);
u_next=ones(ny,nx);
jx=1:nx;
jy=1:ny;
for n=1:N
    for  mx=1:nx %x方向迭代
        uux(mx)=sqrt(i*exp(-i*k*L)/(bochang*L)).*...
            sum(exp(-i*k*((mx)*deltax-(jx)*deltax).^2./(2*L)).*ux)*deltax;%
    end
    ux=uux;
    for my=1:ny %y方向迭代
        uuy(my)=sqrt(i*exp(-i*k*L)/(bochang*L)).*...
            sum(exp(-i*k*((my)*deltax-(jy)*deltax).^2./(2*L)).*uy)*deltax;%
        for o=1:nx %两个方向逐个相乘
            u_next(my,o)=ux(o).*uuy(my);   
        end
    end
    uy=uuy;
    %归一化处理
    ma=max(max(u_next));
    u_next=u_next./ma;
    %自再现判据 
    if (abs(u_next-u_last)<min.*ones(ny,nx))
        break;
    end
    u_last=u_next;
    axes(handles.axes1);
    [XX,YY]=meshgrid(xx,yy);
    mesh(XX,YY,abs(u_last));
    axes(handles.axes2);
    mesh(XX,YY,angle(u_last));
    shading flat;
    set(handles.edit10,'string',num2str(n));
end