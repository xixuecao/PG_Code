% ʹ��ȫ�ֱ���
function x=ex12(t,D)
global D              %����ȫ�ֱ���
t(find(t==0))=eps;    %��ֹ��ĸ����0
x=sin(pi*t/D)./(pi*t/D);