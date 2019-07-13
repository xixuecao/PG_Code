%% Exercise 1
%% Read Image
clear;clc
he = imread('city.jpg');
imshow(he), title('H&E image');
xlabel('Press button!')
pause()
 %% Convert Image from RGB Color Space to L*a*b* Color Space
 lab_he = rgb2lab(he);
 
 %% Classify the Colors in 'a*b*' Space Using K-Means Clustering
ab = lab_he(:,:,2:3);
ab = im2single(ab);
nColors = 3;
% repeat the clustering 3 times to avoid local minima
pixel_labels = imsegkmeans(ab,nColors,'NumAttempts',3);

imshow(pixel_labels,[])
title('Image Labeled by Cluster Index');
xlabel('Press button!')
pause()
%% Create Images that Segment the H&E Image by Color
mask1 = pixel_labels==1;
cluster1 = he .* uint8(mask1);
imshow(cluster1)
title('Objects in Cluster 1');
xlabel('Press button!')
pause()
mask2 = pixel_labels==2;
cluster2 = he .* uint8(mask2);
imshow(cluster2)
title('Objects in Cluster 2');
xlabel('Press button!')
pause()
mask3 = pixel_labels==3;
cluster3 = he .* uint8(mask3);
imshow(cluster3)
title('Objects in Cluster 3');
xlabel('Press button!')
pause()
%% Segment the Nuclei
L = lab_he(:,:,1);
L_blue = L .* double(mask1);
L_blue = rescale(L_blue);
idx_light_blue = imbinarize(nonzeros(L_blue));

blue_idx = find(mask1);
mask_dark_blue = mask1;
mask_dark_blue(blue_idx(idx_light_blue)) = 0;

blue_nuclei = he .* uint8(mask_dark_blue);
imshow(blue_nuclei)
title('Blue Nuclei');
xlabel('End!')