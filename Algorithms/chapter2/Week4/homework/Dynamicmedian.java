package homework;

import edu.princeton.cs.algs4.StdIn;

public class Dynamicmedian<Key extends Comparable<Key>> {
	public Key[] pq;
	private int N= 0;
	@SuppressWarnings("unchecked")
	
	public Dynamicmedian(Comparable[] a) {
		pq = (Key[]) new Comparable[a.length];
		for (int i = 0; i < a.length; i++)
			pq[i]=(Key) a[i];
		sort();
	}
	public void insert(Key v) {
		pq[++N] = v;
		swim(N);
	}
	public Key delMedian() {
		N = pq.length;
		
		Key mid = pq[pq.length / 2];
		exch(pq.length / 2, N--);
		pq[N] = null;
		sink(pq.length / 2, N);
		return mid;
	}
	private void sort() {
		int N = pq.length;
		for (int k = N / 2; k >= 1; k--)
			sink(k, N);
		while (N > 1) {
			exch(1, N);
			sink(1, --N);
		}	
	}
	private void exch(int i, int j) {
		Key t = pq[i - 1];
		pq[i - 1] = pq[j - 1];
		pq[j - 1] = t;
	}
	public boolean less(int i, int j) {
		return pq[i - 1].compareTo(pq[j - 1]) < 0;
	}
	private void sink(int k, int N) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j, j + 1)) j++;
			if (!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k / 2, k);
			k = k / 2;
		}
	}
	public String toString() {
		String s = "";
		for (int i = 0; i < pq.length; i++)
			s += pq[i]+" ";
		return s;
	}
	public static void main(String[] args) {
		String[] a=StdIn.readAllStrings();
		Integer[] array = new Integer[a.length];
		for (int i = 0; i < a.length; i++){
			array[i] = Integer.valueOf(a[i]);
			System.out.print(a[i]+" ");
		}
		Dynamicmedian<Integer> dyn = new Dynamicmedian<Integer>(array);
		System.out.println();
		System.out.print(dyn);
		System.out.println();
		System.out.println(dyn.delMedian());
	}
}
// 5 4 1 2 3 11 13 19