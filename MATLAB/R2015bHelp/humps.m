function y=humps(x)
y=1./((x-0.3).^2+0.01)+1./((x-0.9).^2+0.04)-6;
% x = 0:.002:1;
% y = humps(x);
% plot(x,y);
% p=fminsearch(@humps,0.5);
% humps(p);
% Q=quadl(@humps,0,1);  quadl will be removed in a future release. Use integral instead.
% z=fzero(@humps,0.5);