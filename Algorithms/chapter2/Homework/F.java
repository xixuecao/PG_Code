/*
 * Dutch national flag.
 * Given an array of n buckets, each containing 
 * a red, white, or blue pebble, sort them by color. 
 * 
 * The allowed operations are:
 * 
 * swap(i,j): swap the pebble in bucket i with the pebble in bucket j.
 * color(i): determine the color of the pebble in bucket i.
 * 
 * The performance requirements are as follows:
 * 
 * At most n calls to color().
 * At most n calls to swap().
 * Constant extra space.
 */

import java.util.Arrays;
import edu.princeton.cs.algs4.StdRandom;

public class F {
	private int[] bucket;
	private int N;
	private int callColorNum;
	private int callSwapNum;
	public F(int[] bucket) {
		this.bucket=bucket;
		N=bucket.length;
		callColorNum=0;
		callSwapNum=0;
	}
	public void swap(int i,int j) {
		callSwapNum++;
		int t=bucket[i];
		bucket[i]=bucket[j];
		bucket[j]=t;
	}
	public int color(int i) {
		callColorNum++;
		return bucket[i];
	}
	private void sort() {
		int lo=0,hi=N-1;
		int current=lo;
		while (current<hi) {
			switch (color(current)) {
			case 0:
				if (current!=lo) swap(lo, current);
				current++;
				lo++;
				break;
			case 1:
				current++;
				break;
			case 2:
				swap(hi, current);
				hi--;
				break;
			}
		}
	}
	public void quicksort3way() {
		int lo=0;
		int hi=N-1;
		int i=0;
		while (i<=hi) {
			int color=color(i);
			if (color<1) swap(i++, lo++);
			else if(color>1) swap(i, hi--);
			else i++;
		}
	}
	public static void main(String[] args) {
        int n = 10;
        int[] buckets = new int[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = StdRandom.uniform(3);
        }
        System.out.println(Arrays.toString(buckets));
        F dnf = new F(buckets);
        dnf.quicksort3way();
        System.out.println("after sort call color "+ dnf.callColorNum + " times, call swap "+ dnf.callSwapNum+" times");
        System.out.println(Arrays.toString(buckets));
    }
}
