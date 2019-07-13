package exercise1_4;

import java.util.Arrays;

public class Q1_4_11 {
	private int[] a;
	public Q1_4_11(int[] keys){
		a=new int[keys.length];
		for (int i = 0; i < keys.length; i++)
			a[i]=keys[i];// 保护性复制
		Arrays.sort(a);
	}
	public boolean contains(int key) {
		return rank(key)!=-1;
	}
	public int howMany(int key) {
		int cnt=0;
		int left=rank(key);
		int right=left;
		while (left>0&&a[left--]==key)// 包括key自己和左边
			cnt++;
		while (right>0&&right<a.length-1&&a[++right]==key)// 右边
			cnt++;
		return cnt;
	}
	private int rank(int key) {
		int lo=0;
		int hi=a.length-1;
		while (lo<=hi) {
			int mid=lo+(hi-lo)/2;
			if (key<a[mid]) hi=mid-1;
			else if (key>a[mid]) lo=mid+1;
			else return mid;
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] arr=new int[]{1,4,5,5,2,1,4,2,3,12,2,12};
		Q1_4_11 s=new Q1_4_11(arr);
		System.out.println(s.howMany(12));
	}
}
