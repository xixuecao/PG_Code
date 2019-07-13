// À„∑®2.2 ≤Â»Î≈≈–Ú

import edu.princeton.cs.algs4.StdIn;

public class Insertion {
	public static void sort(Comparable[] a) {
		int N=a.length;
		for (int i = 0; i < N; i++) {
			for (int j = i; j >0&&less(a[j], a[j-1]); j--)
				exch(a, j, j-1);
		}
	}
	public static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length; i++) 
			if (less(a[i], a[i-1])) return false;
		return true;
	}
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w)<0;
	}
	private static void exch(Comparable[] a,int i,int j) {
		Comparable t=a[i];a[i]=a[j];a[j]=t;
	}
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	public static void main(String[] args) {
		String[] a=StdIn.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
//S O R T E X A M P L E