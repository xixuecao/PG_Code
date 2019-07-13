
clear
clc
x=[1:1:12];
y=[1:1:5];
z=[0.2 0.24 0.25 0.26 0.25 0.25 0.25 0.26 0.26 0.29 0.25 0.29;
0.27 0.31 0.3 0.3 0.26 0.28 0.29 0.26 0.26 0.26 0.26 0.29;
0.41 0.41 0.37 0.37 0.38 0.35 0.34 0.35 0.35 0.34 0.35 0.35;
0.41 0.42 0.42 0.41 0.4 0.39 0.39 0.38 0.36 0.36 0.36 0.36;
0.3 0.36 0.4 0.43 0.45 0.45 0.51 0.42 0.4 0.37 0.37 0.37];



%% Fit: 'untitled fit 1'.
[xData, yData, zData] = prepareSurfaceData( x, y, z );

% Set up fittype and options.
ft = fittype( 'poly54' );
opts = fitoptions( 'Method', 'LinearLeastSquares' );
opts.Robust = 'LAR';

% Fit model to data.
[fitresult, gof] = fit( [xData, yData], zData, ft, opts );

% Plot fit with data.
figure( 'Name', 'untitled fit 1' );
h = plot( fitresult, [xData, yData], zData );
legend( h, 'untitled fit 1', 'z vs. x, y', 'Location', 'NorthEast' );
% Label axes
xlabel( 'x' );
ylabel( 'y' );
zlabel( 'z' );
grid on
view( -157.5, 38.0 );
