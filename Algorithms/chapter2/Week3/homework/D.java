package homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import edu.princeton.cs.algs4.StdRandom;

public class D {
	Map<Nut, Bolt> pairs=new HashMap<Nut, Bolt>();
	Nut[] nuts;
	Bolt[] bolts;
	int n;
	
	public D(Nut[] nuts, Bolt[] bolts, int n) {
		this.nuts=nuts;
		this.bolts=bolts;
		this.n=n;
	}
	
	private int compare(NBParent v, NBParent w) {
		int vsize=v.getSize();
		int wsize=w.getSize();
		if (vsize==wsize) return 0;
		else if (vsize>wsize) return 1;
		else return -1;
	}
	
	private void exch(NBParent[] nb, int i, int j) {
		NBParent t=nb[i];
		nb[i]=nb[j];
		nb[j]=t;
	}
	
	public Map<Nut, Bolt> findPairs() {
		sort(bolts, 0, n-1);
		for (int i = 0; i < n; i++) {
			Nut nut=nuts[i];
			Bolt bolt=findBolt(nut);
			if (bolt!=null)
				pairs.put(nut, bolt);
		}
		return pairs;
	}
	
	private Bolt findBolt(Nut nut) {
		int lo=0,hi=n-1;
		while (lo<=hi) {
			int mid=lo+(hi-lo)/2;
			int cr=compare(bolts[mid], nut);
			if (cr<0) lo=mid+1;
			else if (cr>0) hi=mid-1;
			else return bolts[mid];
		}
		return null;
	}
	public void sort(NBParent[] nb, int lo, int hi) {
		if (hi<=lo) return;
		int j=partition(nb, lo, hi);
		sort(nb, lo, j-1);
		sort(nb, j+1, hi);
	}
	
	public int partition(NBParent[] nb,int lo,int hi) {
		int i=lo;
		int j=hi+1;
		NBParent v=nb[lo];
		while (true) {
			while (compare(nb[++i], v)<0) if (i==hi) break;
			while (compare(nb[--j], v)>0) if (j==lo) break;
			if (i>=j) break;
			exch(nb, i, j);
		}
		exch(nb, lo, j);
		return j;
	}
	public static void main(String[] args) {
		int n=10;
		Nut[] nuts=new Nut[n];
		Bolt[] bolts=new Bolt[n];
		for (int i = 0; i < n-1; i++) {
			nuts[i]=new Nut(i+1);
			bolts[i]=new Bolt(i+2);
		}
		nuts[n-1]=new Nut(13);//{1,2,3,4,5,6,7,8,9,13}
		bolts[n-1]=new Bolt(1); //{2,3,4,5,6,7,8,9,10,1}
		StdRandom.shuffle(nuts);
		StdRandom.shuffle(bolts);
		D d=new D(nuts, bolts, n);
		Map<Nut, Bolt> pairs=d.findPairs();
		Iterator<Entry<Nut, Bolt>> iter=pairs.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<Nut, Bolt> e=iter.next();
			Nut nut=e.getKey();
			Bolt bolt=e.getValue();
			System.out.print("<"+nut.getSize()+", "+bolt.getSize()+">, ");
		}
		System.out.println();
	}
}
class NBParent{
	private int size;
	
	public NBParent(int size) {
		this.size=size;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size=size;
	}
}
class Nut extends NBParent{
	public Nut(int size) {
		super(size);
	}
}
class Bolt extends NBParent{
	public Bolt(int size) {
		super(size);
	}
}