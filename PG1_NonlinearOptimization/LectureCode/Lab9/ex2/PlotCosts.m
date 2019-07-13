function PlotCosts(EP)

    EPC=[EP.Cost];
    plot(EPC(1,:),EPC(2,:),'x');
    xlabel('f1');
    ylabel('f2');
    grid on;

end