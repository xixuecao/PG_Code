package exercise1_5;
import edu.princeton.cs.algs4.StdIn;

public class ClassHomework2 {
	private int[] id;
	private int count;
	public ClassHomework2(int N){
		id=new int[N];
		count=N;
		for (int i = 0; i < id.length; i++)
			id[i]=i;
	}
	public int count() {
		return count;
	}
	public boolean connected(int p,int q) {
		return find(p)==find(q);
	}
	public int find(int p) {
		while (p!=id[p]) p=id[p];
		return p;
	}
	public void union(int p,int q) {
		int pID=find(p);
		int qID=find(q);
		if (pID==qID) {
			return;
		}else if (pID<qID) {
			id[pID]=qID;
		}else {
			id[qID]=pID;
		}
		count--;
	}
	public static void main(String[] args) {
		int N=StdIn.readInt();
		ClassHomework2 CH2=new ClassHomework2(N);
		while (!StdIn.isEmpty()) {
			int p=StdIn.readInt();
			int q=StdIn.readInt();
			if (CH2.connected(p, q)) continue;
			CH2.union(p, q);
			System.out.println("link point:"+p+" "+q);
		}
		System.out.println(CH2.count()+" components");
	}
}
