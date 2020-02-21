%% h1
format long
S = input('Mata in ett reellt tal: ');
x = S/2;
for i = 1:10
    x1 = (x+(S/x))/2;
    x = x1;
end
disp(x1)

%% h2
clear
clc
format long
S = input('Mata in ett reellt tal: ');
x = S/2; % xk (nuvarande v?rde)
x2 = -1; % xk-1 (f?rra v?rdet)
x1 = -1; % xk+1 (n?sta v?rde)
i = 0;
while abs(x-x2) > 10e-6 % kolla s? att |xk - xk-1|
    x1 = (x+(S/x))/2; % ta fram n?sta
    x2 = x; % f?rra = nuvarande
    x = x1; % nuvarande = n?sta
    i = i+1;
end

disp(x1)
disp(i)