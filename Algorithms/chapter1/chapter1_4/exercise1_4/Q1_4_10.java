
package exercise1_4;

import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;

public class Q1_4_10 {

		public static void main(String[] args) {
			 int[] arr=new int[]{1,4,1,2,3,3,1,4,5,7,3,5};
		        Arrays.sort(arr);
		        StdOut.println(Arrays.toString(arr));
		        StdOut.println(rank(arr,3));
		        StdOut.println(rank(arr,4));
		}
		public static int rank(int[] a,int k) {
			int lo=0;
			int hi=a.length-1;
			while (lo<=hi) {
				int mid=lo+(hi-lo)/2;
				if (k>a[mid]) lo=mid+1;
				else if (k<a[mid]) hi=mid-1;
				else {
					while (mid>0&&a[--mid]==k);
					return mid+1;
				}
			}
			return -1;
		}
	

}
