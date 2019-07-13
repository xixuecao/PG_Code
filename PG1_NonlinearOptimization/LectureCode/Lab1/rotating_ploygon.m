clear;clc; 
X = [-2 -5 0 5 2];
Y = [-5 3 3 3 -2]; 

h = fill(X,Y,'w');
thetad  = 1;
R = [cosd(thetad) -sind(thetad); sind(thetad) cosd(thetad)];
C = repmat([0 0], length(X), 1)';
axis([-10 10 -10 10])
for k=1:360
    V = get(h,'Vertices')';  % get the current set of vertices
    V = R*(V - C) + C;             % do the rotation relative to the centre of the square
    set(h,'Vertices',V');    % update the vertices
    pause(0.01);
end