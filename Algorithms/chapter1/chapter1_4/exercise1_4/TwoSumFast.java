package exercise1_4;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import exercise1_1.BinarySearch;

public class TwoSumFast {
	public static int count(int[] a) {
		Arrays.sort(a);
		int N=a.length;
		int cnt=0;
		for (int i = 0; i < a.length; i++)
			if (BinarySearch.rank(a, -a[i])>i)// 这里找出来的数字引索必须在上一层循环后面，避免重复
				cnt++;
		return cnt;
	}
	public static void main(String[] args) {
		int[] a=In.readInts(args[0]);
		System.out.println(a.length+": "+count(a)+" triples");
	}
}
