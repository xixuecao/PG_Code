function stop = out1(x,~,~)
stop = false; 
if fun1(x) - 1e-10 < 0
    stop = true;
end

end

