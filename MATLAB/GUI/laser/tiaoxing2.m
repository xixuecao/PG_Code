function tiaoxing2(bochang,m,L,handles)
global n
global point
k=2*pi/bochang;
a=m*1e+006;
deltax=2*a/point;%ȡ��λ����
xx=-a:deltax:a;
L=L*1e+006;
nn=length(xx);
u=ones(1,nn);
jj=1:nn;
N=800;
for n=1:N %���е��� 
    for  b=1:nn
         uu(b)=sqrt(i*exp(-i*k*L)/(bochang*L)).*...
                sum(exp(-i*k*((b-jj)*deltax).^2./(2*L)).*u)*deltax;%   
    end
    ma=max(uu);%���ĵ��uֵ
    uu=uu./ma; 
    %�������о�
   if abs(u-uu)<0.0002*ones(1,nn)      
       break;
   end
   u=uu;
   axes(handles.axes1);
   plot(xx,abs(u))
   axes(handles.axes2);
   plot(xx,angle(u))
   set(handles.edit10,'string',num2str(n));
end

