%��ͼ
function drawTSP(Clist,BSF,bsf)
CityNum=size(Clist,1);
for i=1:CityNum-1
    plot([Clist(BSF(i),1),Clist(BSF(i+1),1)],[Clist(BSF(i),2),Clist(BSF(i+1),2)],'bo-');
    hold on;
end
plot([Clist(BSF(CityNum),1),Clist(BSF(1),1)],[Clist(BSF(CityNum),2),Clist(BSF(1),2)],'bo-');
xlabel(['Route Length = ',num2str(bsf)]) % ��ʾ����ܾ���
title([num2str(CityNum),' Cities GA-TSP']);
hold off;
end
