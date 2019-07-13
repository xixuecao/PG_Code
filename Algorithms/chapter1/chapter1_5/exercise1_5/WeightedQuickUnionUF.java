// 加权quick-union算法
package exercise1_5;
import edu.princeton.cs.algs4.StdIn;

public class WeightedQuickUnionUF {
	private int[] id;
	private int[] sz;
	private int num;// 访问数组次数
	private int count;// 有几个连通的组件
	public WeightedQuickUnionUF(int N){
		// 初始化
		count=N;// 输入几个数有几个组件
		id=new int[N];// 每个id都初始化为自己
		sz=new int[N];
		for (int i = 0; i < id.length; i++) {
			id[i]=i;
			sz[i]=1;
		}
	}
	public boolean connected(int p,int q) {
		return root(p)==root(q);
	}
	public int root(int p) {
		num++;
		while (p!=id[p]) {num+=2;p=id[p];}
		return p;
	}
	public void union(int p,int q) {
		int pID=root(p);
		int qID=root(q);
		if (pID!=qID) {
			if (sz[pID]<sz[qID]) {id[pID]=qID;sz[qID]+=sz[pID];num+=5;}
			else {id[qID]=pID;sz[pID]+=sz[qID];num+=5;}
		}
		count--;
	}
	public String toString() {
		String s="";
		for (int i = 0; i < id.length; i++) {
			s+=id[i]+" ";
		}
		s+="\n";
		for (int i = 0; i < sz.length; i++) {
			s+=sz[i]+" ";
		}
		s+="\n"+count+" components"+"\n"+num+" 访问id[]次"+"\n";
		num=0;
		return s;
	}
	public int count() {
		return count;
	}
	public static void main(String[] args) {
		int N=StdIn.readInt();
		WeightedQuickUnionUF WQU=new WeightedQuickUnionUF(N);
		while (!StdIn.isEmpty()) {
			int p=StdIn.readInt();
			int q=StdIn.readInt();
			if (!WQU.connected(p, q)) {
				WQU.union(p, q);
				System.out.println(p+" "+q);
				System.out.println(WQU);
			}
		}
		
	}
}
// 9 0 3 4 5 8 7 2 2 1 5 7 0 3 4 2