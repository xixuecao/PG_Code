// 三向切分的快速排序

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class Quick3way {
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
		if (hi<=lo) return;
		int lt=lo,i=lo+1,gt=hi;
		Comparable v=a[lo];
		while (i<=gt) {
			int cmp=a[i].compareTo(v);
			if (cmp<0) exch(a, lt++, i++);
			else if(cmp>0) exch(a, i, gt--);
			else i++;
		}
		sort(a, lo, lt-1);// 这里递归是因为输入元素可能不止3种
		sort(a, gt+1, hi);
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
	public static void main(String[] args) {
		String[] a=StdIn.readAllStrings();
		sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
}
// 3种元素 R B W W R W B R R W B R
// 4种元素 R B W C C W R W B R R W B R