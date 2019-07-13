package exercise1_5;
import edu.princeton.cs.algs4.StdIn;

public class QuickUnion {
	private int[] id;
	private int count;
	private int num;
	public QuickUnion(int N) {
		count=N;
		id=new int[N];
		for (int i = 0; i < id.length; i++) {
			id[i]=i;
		}
	}
	public int count() {
		return count;
	}
	public boolean connected(int p,int q) {
		return root(p)==root(q);
	}
	public int root(int p) {
		num++;
		while (p!=id[p]) {num++;p=id[p];num++;}
		return p;
	}
	public void union(int p,int q) {
		int pRoot=root(p);
		int qRoot=root(q);
		if (pRoot==qRoot) return;
		id[pRoot]=qRoot;
		num++;
		count--;
	}
	public String toString() {
		String s="";
		for (int i = 0; i < id.length; i++) {
			s+=id[i]+" ";
		}
		s+="\n"+count+" components"+"\n"+num+" 访问id[]次";
		num=0;// 每次比较完输出数组后置零num
		return s;
	}
	public static void main(String[] args) {
		int N=StdIn.readInt();
		QuickUnion QU=new QuickUnion(N);
		while (!StdIn.isEmpty()) {
			int p=StdIn.readInt();
			int q=StdIn.readInt();
			if (!QU.connected(p, q)) {
				QU.union(p, q);
				System.out.println(p+" "+q);
				System.out.println(QU);
			}
		}
		
	}
}
// 9 0 3 4 5 8 7 2 2 1 5 7 0 3 4 2