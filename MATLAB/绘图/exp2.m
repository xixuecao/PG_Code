%Í¼Ïñ·Ö²¼
x=0:0.4:8;
y=2*exp(-0.5*x);

subplot(2,2,1);bar(x,y,'r');       %ÌõĞÎÍ¼
title('bar(x,y,''red'')');axis([-.2,8.1,-.1,2.1]);

subplot(2,2,2);stairs(x,y,'b');    %½×ÌİÍ¼
title('stairs(x,y,''blue'')');axis([-.2,8.1,-.1,2.1]);

subplot(2,2,3);stem(x,y,'g');      %¸ËÍ¼
title('stem(x,y,''green'')');axis([-.2,8.1,-.1,2.1]);

subplot(2,2,4);fill(x,y,'y');      %Ìî³äÍ¼
title('fill(x,y,''yellow'')');axis([-.2,8.1,-.1,2.1]);
