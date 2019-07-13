syms u(x) x
u(x)=dsolve('D3u=u','u(0)=1','Du(0)=-1','D2u(0)=pi')
simplify(u)