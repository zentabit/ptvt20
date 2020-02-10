
%% Uppgift d2
disp(pi)
disp(sqrt(3))
disp(sqrt(-3))
disp(sqrt(i))
disp(exp(pi*i))


%% uppgift d3
z = sqrt(-3);
disp(abs(z))
disp(angle(z))

z = sqrt(i);
disp(real(z))
disp(imag(z))

 %% Komplexa tal   
 a = 3 + 2i; 
 b = 5 - i; 
 x = a * b 
 
 % Den sista f?r att vi inte supressar den
 
 
%% Funktioner
g = @(x) exp(-0.1*x).*cos(x);
x = linspace(0,10);
% Att det ?r en radvektor, 100st, ja
y = g(x);
plot(x,y)

%% Derivator
h = 1e-6;
%y = @(x) 2*x;

deriv = @(f,x) (f(x+h)-f(x))/h;

hold on
plot(x,y)
plot(x, deriv(g, x), 'r-') 
hold off

title('Funktionen och dess derivata') 
legend('funktion', 'derivata') 
print('funktionsbild','-dpng')

%% Unders?ka derivator
h1 = @(x) exp(-0.1.*x).*cos(x)-0.1.*exp(-0.1.*x).*sin(x);
h2 = @(x) -0.1.*exp(-0.1.*x).*cos(x)-exp(-0.1.*x).*sin(x);
h3 = @(x) -0.1.*exp(-0.1.*x).*cos(x)-0.1.*exp(-0.1.*x).*sin(x);

hv1 = h1(x);
hv2 = h2(x);
hv3 = h3(x);
der = deriv(g,x);

diff1 = hv1 - der;
diff2 = hv2 - der;
diff3 = hv3 - der;
norm(diff1)
norm(diff2)
norm(diff3)

%% Matriser
del1 = 5*eye(5);
del2 = 6*ones(4,5);
M = [del1;del2]

A = [ 4 4 8 ; 8 4 4 ; 3 6 3];
y1 = [-8;-32;6];
x1 = A\y1
A*x1
% st?mmer

B = [ 1 1 -1 ; 2 1 1 ; 4 3 -1];
det(B)
y2 = [2;3;4];
x2 = B\y2
% l?sning saknas