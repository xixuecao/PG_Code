lamd=str2double(get(handles.LL,'String'));
N=str2double(get(handles.NN,'String'));
f=str2double(get(handles.ff,'String'));
a=str2double(get(handles.aa,'String'));
d=str2double(get(handles.dd,'String'));
x=linspace(-12,12,1000);
for i=1:1000
    u=(pi*a/lamd)*((x(i)/sqrt(x(i)^2+f^2)));
    I(i)=((sin(u)/u)^2)*((sin(d*u*N/a)/sin(d*u/a))^2);
end