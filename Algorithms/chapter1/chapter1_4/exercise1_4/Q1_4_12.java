package exercise1_4;

public class Q1_4_12 {
	public static void print(int[] a,int[] b) {
		int ai=0;
		int bi=0;
		int len=a.length+b.length;
		for (int i = 0; i < len; i++) {
			if (a[ai]>b[bi]) {
				bi++;
				if (bi==b.length)
					break;
			}else if (a[ai]<b[bi]) {
				ai++;
				if (ai==a.length)
					break;
			}else {
				System.out.printf("%d  ", a[ai]);
				ai++;bi++;
				if (ai==a.length||bi==b.length)
					break;
			}
		}
	}
	public static void main(String[] args) {
		int[] arr1=new int[]{2,2,3};
        int[] arr2=new int[]{1,2,3};
        print(arr1, arr2);
	}
}
