package homework;

import java.util.Arrays;
import edu.princeton.cs.algs4.StdRandom;

public class E {
	private static int find(int[] a, int alo, int ahi, int[] b, int blo, int bhi, int k) {
		if (alo>ahi) return b[bhi-k+1];
		if (blo>bhi) return a[ahi-k+1];
		if (k == 1) return a[ahi]>b[bhi]?a[ahi]:b[bhi];
		
		int bt=bhi-(k-1)/2>blo?bhi-(k-1)/2:blo;
		int at=ahi-(k-1)/2>alo?ahi-(k-1)/2:alo;
		if (a[at]>=b[bt]) return find(a, alo, at-1, b, blo, bhi, k-(ahi-at+1));
		else return find(a, alo, ahi, b, blo, bt-1, k-(bhi-bt+1));
	}
	
	public static void main(String[] args) {
		int n=10;
		int n1=StdRandom.uniform(n);
		int n2=n-n1;
		int[] a=new int[n1];
		int[] b=new int[n2];
		for (int i = 0; i < n1; i++)
			a[i]=StdRandom.uniform(100);
		for (int i = 0; i < n2; i++)
			b[i]=StdRandom.uniform(100);
		Arrays.sort(a);
		Arrays.sort(b);
		System.out.println("a="+Arrays.toString(a));
		System.out.println("b="+Arrays.toString(b));
		int[] c=new int[n];
		int i=0,j=0,k=0;
		while (k<n) {
			if (i>=n1) c[k++]=b[j++];
			else if (j>=n2) c[k++]=a[i++];
			else {
				if (a[i]<=b[j])
					c[k++]=a[i++];
				else
					c[k++]=b[j++];
			}
		}
		System.out.println("c="+Arrays.toString(c));
		
		int kth=StdRandom.uniform(1,n);
		int kthValue=find(a, 0, n1-1, b, 0, n2-1, kth);
		System.out.println("第 "+kth+" 大的元素:"+kthValue);
	}
}
