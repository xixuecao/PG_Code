[x,y,z] = peaks;

surf(x,y,z)% Create surface plot

shading interp% Remove edge lines a smooth colors

hold on% Hold the current graph

contour3(x,y,z,20,'k')% Add the contour graph to the pcolor graph

hold off% Return to default