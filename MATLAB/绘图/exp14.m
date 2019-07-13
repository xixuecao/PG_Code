%clear;clc;
solve('((-400-350)/80)*(x-40)-400','x')
line([-40,40],[350,-400]);
hold on
refline(0,0);
plot(-8/3,0,'.r','MarkerSize',15)
hold off
grid on
gtext('(-8/3,0)')