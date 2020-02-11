%% d1
y = [5 0 -75 -70 1404 2520]
z = roots(y)
x = linspace(-10, 10);
plot(x, polyval(y,x))
d = polyval(y,z)

%% d2
z = poly([-7 -6 -5 8])
x = linspace(-50, 50, 1000);
plot(x, polyval(z, x))

%% d3
f = @(t) 3.*exp(-0.2.*t)+4.*cos(2.*t);
S = integral(f, 1.5, 3.3)
x = linspace(0, 5);
plot(x, f(x))
grid on

%% d4
g = @(x) cos(exp(x))./(1-x);
x = linspace(2,3);
z1 = fminbnd(g,2,2.8)
z2 = fminbnd(g,2.8,3)
f(z1)
f(z2)
plot(x, g(x))
grid on

%% d5
h = @(x) 3.*x.^2+2.*x-2.*exp(-x.^2);
x = linspace(-5,5);
plot(x, h(x))
z1 = fzero(h, -1)
z3 = fzero(h, 1)
h(z1)
z2 = fminbnd(h, -1, 1)
h(z2)

%% d6
format short
A = 4*eye(10)
v = 5*ones(1, 9)
B = diag(v, 1)
C = diag(v, -1)
M = A + B + C
det(M)
