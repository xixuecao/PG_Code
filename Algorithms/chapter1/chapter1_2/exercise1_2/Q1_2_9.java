package exercise1_2;

import java.util.Arrays;
import edu.princeton.cs.algs4.*;

public class Q1_2_9 {
	public static void main(String[] args) {
		System.out.print("N: ");
		int N = StdIn.readInt();
		int[] whitelist = new int[N];
		System.out.print("list: ");
		for (int i = 0; i < N; i++) {
			whitelist[i] = StdIn.readInt();
		}
		Arrays.sort(whitelist);
		System.out.print("list: ");
		for (int i = 0; i < whitelist.length; i++) {
			System.out.print(whitelist[i]+" ");
		}
		System.out.println();
		System.out.print("key: ");
		int key = StdIn.readInt();
		Counter counter = new Counter("keys");
		System.out.println(rank(key, whitelist, counter));
	}
	
	public static int rank(int key, int[] a,Counter counter) {
		int lo=0;
		int hi=a.length-1;
		return rank(key, a, lo, hi, counter);
	}
	public static int rank(int key, int[] a,int lo,int hi,Counter counter) {
		// ��������������
		
		if (lo>hi) return -1;
		counter.increment();
		//�����ҵļ�Ҫô������a[lo,...,hi]֮�У�Ҫô������
		int mid=lo+(hi-lo)/2;
		System.out.print(counter);
		System.out.println(" mid="+mid);
		if (key<a[mid]) return rank(key, a, lo, mid - 1, counter);
		else if (key>a[mid]) return rank(key, a, mid + 1, hi, counter);
		else return mid;
		
	}
}
