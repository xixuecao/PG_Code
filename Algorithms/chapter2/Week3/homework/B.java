package homework;

import java.util.Arrays;

public class B {
	private static Comparable[] aux;
	private static int num;
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w)<0;
	}
	public static int numt(Comparable[] a) {
		aux=new Comparable[a.length];
		sort(a, 0, a.length-1);
		return num;
	}
	private static void sort(Comparable[] a,int lo,int hi) {
		if (hi<=lo) return;
		int mid=lo+(hi-lo)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		merge(a, lo, mid, hi);
	}
	private static void merge(Comparable[] a,int lo,int mid,int hi) {
		int i=lo,j=mid+1;
		for (int k = lo; k <= hi; k++) 
			aux[k]=a[k];
		for (int k = lo; k <=hi; k++) {
			if (i>mid) a[k]=aux[j++];
			else if (j>hi) a[k]=aux[i++];
			else if (less(aux[j], aux[i])) {a[k]=aux[j++];num+=mid-i+1;}
			else a[k]=aux[i++];
		}
	}
	public static void main(String[] args) {
		Integer[] a={6,5,2,3,4,1};
		System.out.println(numt(a));
		System.out.println(Arrays.toString(a));
	}
}
