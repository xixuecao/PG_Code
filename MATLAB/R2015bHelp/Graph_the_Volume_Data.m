load wind
wind_speed = sqrt(u.^2 + v.^2 + w.^2);
figure
p = patch(isosurface(x,y,z,wind_speed,35));
isonormals(x,y,z,wind_speed,p)
p.FaceColor = [0.75,0.25,0.25];
p.EdgeColor = [0.6,0.4,0.4];
[f,vt] = reducepatch(isosurface(x,y,z,wind_speed,45),0.05);
daspect([1,1,1]);
hcone = coneplot(x,y,z,u,v,w,vt(:,1),vt(:,2),vt(:,3),2);
hcone.FaceColor = 'blue';
hcone.EdgeColor = 'none';