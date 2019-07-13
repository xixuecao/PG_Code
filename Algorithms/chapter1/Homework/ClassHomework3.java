

public class ClassHomework3 {
	private int num;
	private int[] id;
	private boolean[] isRemove;

	public ClassHomework3(int N){
		num=N;
		id=new int[N];
		isRemove=new boolean[N];
		for (int i = 0; i < N; i++) {
			id[i]=i;
			isRemove[i]=false;
		}
	}
	
	public int find(int p) {
		while (p!=id[p]) p=id[p];
		return p;
	}
	
	public void union(int p,int q) {
		int pID=find(p);
		int qID=find(q);
		if (pID==qID) return;
		else if (pID<qID) id[pID]=qID;
		else id[qID]=pID;
	}

	public void remove(int x) {
		isRemove[x]=true;
		if (x>0&&isRemove[x-1])
			union(x, x-1);
		if (x<num-1&&isRemove[x+1])
			union(x, x+1);
	}
	
	public int Successor(int x) {
		if (x<0||x>num-1) {
			throw new IllegalArgumentException();
		}else if (isRemove[x]) {
			if (find(x)+1>num-1) {
				return -1;
			}else {
				return find(x)+1;
			}
		}else {
			return x;
		}
	}
	public static void main(String[] args) {
		ClassHomework3 CH3 = new ClassHomework3(10);
		CH3.remove(2);
		CH3.remove(3);
		System.out.println(CH3.Successor(2));
		CH3.remove(9);
		System.out.println(CH3.Successor(9));
	}
	
}
