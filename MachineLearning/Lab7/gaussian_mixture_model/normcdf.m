function cdf = normcdf(x, mu, sigma)
% normal CDF
% 
% INPUTS:
%   x      = a vector of points at which to calculate the normal CDF 
%   mu     = mean of the normal
%   sigma  = std dev. of the normal
%
cdf = 0.5 * erfc(-(x-mu)/(sigma*sqrt(2)));

