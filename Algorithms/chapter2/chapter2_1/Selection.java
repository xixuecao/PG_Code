// 算法2.1 选择排序

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

public class Selection {
	public static void sort(Comparable[] a) {
		int N=a.length;
		for (int i = 0; i < N; i++) {
			int min=i;
			for (int j = i+1; j < N; j++)
				if (less(a[j], a[min])) min=j;// 找到最小的数的引索
			exch(a, i, min);// 交换a[i]和a[i+1,...,N]中最小的元素
		}
	}
	public static void drawSort(Comparable[] a) {
		int N=a.length;
		StdDraw.setCanvasSize(N + 1, N + 1);
		for (int i = 0; i < N; i++) {
			int min=i;
			for (int j = i+1; j < N; j++)
				if (less(a[j], a[min])) min=j;// 找到最小的数的引索
			exch(a, i, min);// 交换a[i]和a[i+1,...,N]中最小的元素
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
// S O R T E X A M P L E