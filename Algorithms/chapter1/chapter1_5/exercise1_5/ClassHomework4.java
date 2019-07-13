package exercise1_5;

import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class ClassHomework4 {
	// A+B=k
	public static int twoSumFaster(int[] a,int k,int i) {
		int first=i;
		int last=a.length-1;
		int cnt=0;
		while (first<last) {
			if (a[first]+a[last]<k) {
				first++;
			}else if (a[first]+a[last]>k) {
				last--;
			}else {
				cnt++;
				while (first<last&&a[first]==a[++first]);
				while (last>first&&a[last]==a[--last]);
			}
		}
		return cnt;
	}
	
	public static int threeSumFaster(int[] a) {
		int cnt=0;
		for (int i = 0; i < a.length-1; i++) {
			int k=-a[i];
			cnt+=twoSumFaster(a, k, i+1);
		}
		return cnt;
	}

	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		int[] a=In.readInts(StdIn.readString());
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		System.out.println(threeSumFaster(a));
	}
}
/*
E:\LUBO\Java\homework4.txt

30 -40 -20 -10 40 0 10 5
*/