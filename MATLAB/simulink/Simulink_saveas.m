formats={'bmp','emf','pdf','pgm','png','ppm','tiff'};
name='simulink_saveas';
for ii = 1:length(formats)
    saveas(get_param(gcs,'handle'),name,formats{ii});
end