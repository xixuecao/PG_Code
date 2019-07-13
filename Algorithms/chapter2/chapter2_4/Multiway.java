// 使用优先列队的多向归并

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;

public class Multiway {
	public static void merge(In[] streams) {
		int N=streams.length;
		IndexMinPQ<String> pq=new IndexMinPQ<String>(N);
		
		for (int i = 0; i < N; i++)
			if (!streams[i].isEmpty())
				pq.insert(i, streams[i].readString());
		
		while (!pq.isEmpty()) {
			System.out.print(pq.minKey()+" ");
			int i=pq.delMin();
			if (!streams[i].isEmpty())
				pq.insert(i, streams[i].readString());
		}
	}
	
	public static void main(String[] args) {
		int N=args.length;
		In[] streams=new In[N];
		for (int i = 0; i < N; i++)
			streams[i]=new In(args[i]);
		merge(streams);
	}
}
/*  % more m1.txt 
*  A B C F G I I Z
*
*  % more m2.txt 
*  B D H P Q Q
* 
*  % more m3.txt 
*  A B E F J N
*  
*  F:\Algorithms\Week4\Data\m1.txt
*  F:\Algorithms\Week4\Data\m2.txt
*  F:\Algorithms\Week4\Data\m3.txt
*/