function result = complexmat(N, z0, z1)
    % skapar en N x N-matris med komplexa tal a + bi
    % d?r re(z0) <= a <= re(z1) och im(z1) <= b <= im(z0)
    % (j?mnt f?rdelade i matrisen)
 
    xs = linspace(real(z0), real(z1), N);  % realdelar
    ys = linspace(imag(z0), imag(z1), N);  % imagin?rdelar
 
    % skapa tv? matriser med real- respektive imagin?rdelar
    [X, Y] = meshgrid(xs, ys);
 
    % matrisen X inneh?ller resultatets realdelar
    % matrisen Y inneh?ller resultatets imagin?rdelar
 
    result = X + Y.*i;    % <<< denna rad beh?ver ut?kas
end