package exercise1_3;

import edu.princeton.cs.algs4.*;

public class TestQueue {
	public static void main(String[] args) {
		//E:\LUBO\Java\MyText.txt
		int[] ints=readInts(args[0]);
		for (int i = 0; i < ints.length; i++)
			System.out.println(ints[i]);
	}
	
	public static int[] readInts(String name) {
		In in=new In(name);
		Queue<Integer> q=new Queue<Integer>();
		while (!in.isEmpty()) {
			q.enqueue(in.readInt());
		}
		
		int N=q.size();
		int[] a=new int[N];
		for (int i = 0; i < a.length; i++)
			a[i]=q.dequeue();
		return a;
	}
}
