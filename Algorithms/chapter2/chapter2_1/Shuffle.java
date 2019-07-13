// Ï´ÅÆ

import edu.princeton.cs.algs4.StdRandom;

public class Shuffle {
	private static void exch(Object[] a,int i,int j) {
		Object t=a[i];a[i]=a[j];a[j]=t;
	}
	public static void shuffle(Object[] a) {
		int N=a.length;
		for (int i = 0; i < N; i++) {
			int r=StdRandom.uniform(i+1);
			exch(a, i, r);
		}
	}
}
