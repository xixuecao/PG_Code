package homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import edu.princeton.cs.algs4.StdRandom;
/**
 * ��ñ��
 * @author evasean www.cnblogs.com/evasean/
 */
public class Test {
    Map<Nut, Bolt> pairs = new HashMap<Nut, Bolt>(); // �洢��Ե���ñ����˿��
    Nut[] nuts;
    Bolt[] bolts;
    int n;

    public Test(Nut[] nuts, Bolt[] bolts, int n) {
        this.nuts = nuts;
        this.bolts = bolts;
        this.n = n;
    }

    private int compare(NBParent v, NBParent w) {
        int vsize = v.getSize();
        int wsize = w.getSize();
        if (vsize == wsize) return 0;
        else if (vsize > wsize) return 1;
        else return -1;
    }
    private void exch(NBParent[] nb, int i, int j){
        NBParent t = nb[i];
        nb[i]=nb[j];
        nb[j]=t;
    }
    
    public Map<Nut, Bolt> findPairs() {
        sort(bolts,0,n-1); //�ȶ�bolts���п�������
        for(int i = 0; i<n;i++){ //����nuts������bolts��Ѱ����ɶԵ�bolt
            Nut nut = nuts[i];
            Bolt bolt= findBolt(nut); 
            if(bolt != null)
                pairs.put(nut, bolt);
        }
        return pairs;
    }
    private Bolt findBolt(Nut nut){ //���ź����bolts�ж��ֲ���nut
        int lo = 0; 
        int hi = n-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            int cr = compare(bolts[mid],nut);
            if(cr<0) lo = mid+1;
            else if(cr>0) hi = mid-1;
            else return bolts[mid];
        }
        return null;
    }
    private void sort(NBParent[] nb, int lo, int hi){
        if(hi<=lo) return;
        int j = partition(nb,lo,hi);
        sort(nb,lo,j-1);
        sort(nb,j+1,hi);
    }
    
    private int partition(NBParent[] nb, int lo, int hi){
        int i = lo;
        int j = hi+1;
        NBParent v = nb[lo];
        while(true){
            while(compare(nb[++i],v)<0) if(i==hi) break;
            while(compare(nb[--j],v)>0) if(j==lo) break;
            if(i>=j) break;
            exch(nb,i,j);
        }
        exch(nb,lo,j);
        return j;
    }

    public static void main(String[] args) {
        int n = 10;
        Nut[] nuts = new Nut[n];
        Bolt[] bolts = new Bolt[n];
        for (int i = 0; i < n-1; i++) {
            Nut nut = new Nut(i + 1);
            nuts[i] = nut;
            Bolt bolt = new Bolt(i + 2);
            bolts[i] = bolt;
        }
        //������һ�Բ�һ����
        nuts[n-1] = new Nut(13);//nuts��size�ֱ�Ϊ{1,2,3,4,5,6,7,8,9,13}
        bolts[n-1] = new Bolt(1);//bolts��size�ֱ���{2,3,4,5,6,7,8,9,10,1}
        StdRandom.shuffle(nuts);
        StdRandom.shuffle(bolts);
        Test nb = new Test(nuts, bolts, n);
        Map<Nut, Bolt> pairs = nb.findPairs();
        Iterator<Entry<Nut, Bolt>> iter = pairs.entrySet().iterator();
        while(iter.hasNext()){
            Entry<Nut, Bolt> e = iter.next();
            Nut nut = e.getKey();
            Bolt bolt = e.getValue();
            System.out.print("<"+nut.getSize()+","+bolt.getSize()+">,");
        }
        System.out.println();
    }
}