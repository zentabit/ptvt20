m = complexmat(10000, -2+i, 1-i);

%m = complexmat(1000, -0.7+0.7i, -0.5+0.6i);
v = arrayfun(@converge, m);
image(v)