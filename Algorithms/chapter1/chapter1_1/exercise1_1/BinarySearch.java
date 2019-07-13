package exercise1_1;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class BinarySearch {
	public static void main(String[] args) {
		int[] whitelist=In.readInts(args[0]);
		Arrays.sort(whitelist);
		while (!StdIn.isEmpty()) {
			int k=StdIn.readInt();
			if (rank(whitelist, k)<0)
				System.out.println(k);
		}
	}
	public static int rank(int[] a,int k) {
		int lo=0;
		int hi=a.length-1;
		while (lo<=hi) {
			int mid=lo+(hi-lo)/2;
			if (k>a[mid]) lo=mid+1;
			else if (k<a[mid]) hi=mid-1;
			else return mid;
		}
		return -1;
	}
}
