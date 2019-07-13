[X,Y] = meshgrid(-8:.5:8);
R = sqrt(X.^2 + Y.^2) + eps;
Z = sin(R)./R;

%% Graphing the sinc Function
mesh(X,Y,Z)
surf(X,Y,Z)
shading interp

%% Colored Surface Plots
% surf(X,Y,Z)
% colormap hsv
% colorbar

%% Making Surfaces Transparent
% surf(X,Y,Z)
% colormap hsv
% alpha(.4)

%% Illuminating Surface Plots with Lights
% surf(X,Y,Z,'FaceColor','red','EdgeColor','none')
% camlight left;
% lighting phong
%% Print
% print -dpng matlab.png
 
% set(gcf,'PaperPositionMode','auto')
% print -dpng -r0 matlab.png
% To save the figure at the same size as the figure on the screen
% print -dtiff -r200 matlab.tiff
% To save the same figure as a TIFF file with a resolution of 200 dpi
% print
% the current figure prints on your default printer