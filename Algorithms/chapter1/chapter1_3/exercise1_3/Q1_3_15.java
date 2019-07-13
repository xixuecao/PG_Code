package exercise1_3;

import edu.princeton.cs.algs4.StdIn;

public class Q1_3_15 {
	
		
	public void reversePrint(int k) {
		Queue<String> queue=new Queue<String>();
		while (!StdIn.isEmpty()) {
			queue.enqueue(StdIn.readString());
		}
		int n=queue.size();
		for (int i = 0; i < n; i++) {
			String s=queue.dequeue();
			if (i==n-k) {
				System.out.println(s);
			}
		}
	}
	public static void main(String[] args) {
		
		System.out.print("ÊäÈëk£º ");
		int k=StdIn.readInt();
		System.out.println("ÊäÈë×Ö·û´®×é£º ");
		Q1_3_15 q=new Q1_3_15();
		q.reversePrint(k);
	}
}
