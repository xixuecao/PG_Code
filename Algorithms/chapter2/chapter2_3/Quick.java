// �㷨2.5 ��������

import edu.princeton.cs.algs4.StdRandom;

public class Quick {
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length-1);
	}
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w)<0;
	}
	private static void exch(Comparable[] a,int i,int j) {
		Comparable t=a[i];a[i]=a[j];a[j]=t;
	}
	private static void sort(Comparable[] a,int lo,int hi) {
		int M=10;
		if (hi<=lo) return;
		// if (hi<=lo+M) Insertion.sort(a);
		int j=partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	private static int partition(Comparable[] a,int lo,int hi) {
		int i=lo,j=hi-1;
		Comparable v=a[lo];
		while (true) {
			while (less(a[++i], v)) if (i==hi) break;
			while (less(v, a[--j])) if (j==lo) break;
			if (i>=j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
}
