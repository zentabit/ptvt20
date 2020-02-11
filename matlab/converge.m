function iterations = converge(c)
    z = c;
    iterations = 0;
    while abs(z) <= 2 && iterations < 100
        z = z*z + c;
        iterations = iterations +1;
    end
    
end

