package homework;
import java.util.Arrays;
import edu.princeton.cs.algs4.StdRandom;

public class A {
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w)<0;
	}
	public static void merge(Comparable[] array) {
		int N=array.length/2;
		Comparable[] aux=new Comparable[N];
		for (int i = 0; i < N; i++)
			aux[i]=array[i];
		System.out.println(Arrays.toString(aux));
		int l=0;
		int r=N;
		for (int k = 0; k < 2*N ; k++) {
			if (l>=N) break;// 当辅助数组下限结束
			else if (r>=2*N) array[k]=aux[l++];// 说明加了N下r，r到了2N，array没有了，即右边全部放进去了，只剩下左边
			else if (less(array[r], aux[l])) array[k]=array[r++];
			else array[k]=aux[l++];
		}
	}
	public static void main(String[] args) {
		int N=11;
		int[] subarray1=new int[N];
		int[] subarray2=new int[N];
		for (int i = 0; i < N; i++) {
			subarray1[i]=StdRandom.uniform(100);
			subarray2[i]=StdRandom.uniform(100);
		}
		Arrays.sort(subarray1);
		Arrays.sort(subarray2);
		Integer[] array=new Integer[2*N];
		for (int i = 0; i < N; i++) {
			array[i]=subarray1[i];
			array[N+i]=subarray2[i];
		}
		System.out.println(Arrays.toString(array));
		merge(array);
		System.out.println(Arrays.toString(array));
	}
}
