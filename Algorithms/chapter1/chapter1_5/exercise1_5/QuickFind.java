package exercise1_5;
import edu.princeton.cs.algs4.StdIn;

public class QuickFind {
	private int[] id;
	private int count;
	private int num;
	public QuickFind(int N){
		count=N;
		id=new int[N];
		for (int i = 0; i < id.length; i++)
			id[i]=i;
	}
	public boolean connected(int p,int q) {
		return find(p)==find(q);
	}
	public int count() {
		return count;
	}
	public int find(int p) {
		num++;
		return id[p];
	}
	public void union(int p,int q) {
		int pID=find(p);
		int qID=find(q);
		// �˴�Ҳ���Բ�����Ƿ���ȣ���Ϊ��main�������Ѿ�������Ƿ�connected
		if (pID==qID) return;
		for (int i = 0; i < id.length; i++){
			num++;
			if (id[i]==pID) {num++;id[i]=qID;}
		}
		count--;
	}
	public String toString() {
		String s="";
		for (int i = 0; i < id.length; i++) {
			s+=id[i]+" ";
		}
		s+="\n"+count+" components"+"\n"+num+" ����id[]��";
		num=0;// ÿ�αȽ���������������num
		return s;
	}
	public static void main(String[] args) {
		int N=StdIn.readInt();
		QuickFind QF=new QuickFind(N);
		while (!StdIn.isEmpty()) {			
			
			int p=StdIn.readInt();
			int q=StdIn.readInt();
			if (!QF.connected(p, q)) {
				QF.union(p, q);
				System.out.println(p+" "+q);
				System.out.println(QF);
			}
		}
	}
}
// 9 0 3 4 5 8 7 2 2 1 5 7 0 3 4 2