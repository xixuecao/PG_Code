function p = norm_density(x, mu, sigma)
% Compute density of normal distribution function
% 
% Calculate normal density in 1D.
% 
% INPUTS:
%   x      = a vector of points at which to calculate the normal CDF 
%   mu     = mean of the normal
%   sigma  = std dev. of the normal
%
p = exp( -(x-mu).^2 / (2*sigma^2) ) / (sigma * sqrt(2*pi) );
