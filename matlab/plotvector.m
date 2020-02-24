[x,y] = meshgrid(linspace(0,10,50),linspace(0,10,50));
u = sin(y);
v = sin(x);

quiver(x,y,u,v);