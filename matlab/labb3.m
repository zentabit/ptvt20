%% d1
f = @(t,y) 4*t+4*cos(2*t)-2*y^2;
[t,y] = ode45(f, [3 10], 6)
plot(t, y)
% y(6) = 3.66

%% d2
x = [ 0.000 1.000 2.000 3.000 4.000 5.000 ];
y = [ 3.749 4.689 6.273 5.897 6.381 7.003 ];
hold on
plot(x,y, 'r+')
p = polyfit(x,y,5);
x1 = linspace(0,5);
%x1 = linspace(0,10);
plot(x1, polyval(p,x1))
l = polyfit(x,y,1);
plot(x1, polyval(l,x1))

%% d3
x = [ 0.10 0.20 0.30 0.40 0.50 0.60 0.70 0.80 0.90 1.00 1.10 1.20 1.30 1.40 1.50 ];
y = [ 1.16 1.72 1.69 2.19 2.36 2.34 2.37 2.70 2.67 2.59 2.82 2.68 2.93 3.15 2.89 ];

p = polyfit(x,exp(y),1)
x1 = linspace(0,2);
hold on
plot(x,y, 'r+')
plot(x1, log(polyval(p,x1)))
hold off

%% d4 - d6
%urlwrite('http://cs.lth.se/edaa55/matlab/race', 'race.txt');

v = csvread('race.txt');
size(v)
v(1);
v(450);
xs = linspace(0,40,6000);
size(xs)
%plot(xs, v)
%v(find(v>80)) = 0;
v(find(v>80)) = v(find(v>80)-1);
plot(xs, v)
v(6000) % maxhast ca 70m/s
s = trapz(xs, v)
medelv = s/40

%% d7 -d8
%urlwrite('http://cs.lth.se/edaa55/matlab/const-accel', 'const_accel.txt')
v2 = csvread('const_accel.txt');
size(v2)
ts = linspace(0,5, 750).';
size(ts)
hold on
plot(ts,v2)
p = polyfit(ts, v2, 1);
plot(ts, polyval(p, ts))
hold off
p(1)

%% d9 -d10
M = 1171.42;
r = 0.3515;
C = 0.24;
A = 2.4;
roo = 1.29;
m = 2107.98;
F = @(v) 4.*M./r - 0.5*C.*roo.*A.*v.^2;
F(0)
F(30)

a = @(t,v) F(v)./m;
[t,y] = ode45(a, [0 3], 0);
plot(t,y)
y(end)
v(450)