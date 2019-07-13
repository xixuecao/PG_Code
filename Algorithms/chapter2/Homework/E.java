/*
 * Permutation. 
 * Given two integer arrays of size n, design 
 * a subquadratic algorithm to determine whether
 * one is a permutation of the other. That is, 
 * do they contain exactly the same entries but, 
 * possibly, in a different order.
 */

import java.util.Arrays;

public class E {
	private static boolean less(int v,int w) {
		return v<w;
	}
	private static void exch(int[] a,int i,int j) {
		int t=a[i];a[i]=a[j];a[j]=t;
	}
	public static boolean isPermutation(int[] a,int[] b) {
		sort(a);
		System.out.println(Arrays.toString(a));
		sort(b);
		System.out.println(Arrays.toString(b));
		for (int i = 0; i < a.length; i++) {
			if (a[i]!=b[i]) return false;
		}
		return true;
	}
	public static void sort(int[] a) {
		int N=a.length;
		int h=1;
		while (h<N/3) h=3*h+1;
		while (h>=1) {
			for (int i = 0; i < N; i++) {
				for (int j =i; j >=h&&less(a[j], a[j-h]); j-=h) 
					exch(a, j, j-h);
			}
			h=h/3;
		}
	}
	public static void main(String[] args){
        int[] a = {1,2,4,5,6,11,9,7,8,0};
        int[] b = {0,9,8,7,6,5,4,3,2,1};
        System.out.println(isPermutation(a,b));
    }
}
