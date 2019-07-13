

public class ClassHomework5{
	private static int seaarchLeft(int[] a,int key,int lo,int hi) {
		int mid=0;
		while (lo<=hi) {
			mid=lo+(hi-lo)/2;
			if (key>a[mid]) lo=mid+1;
			else if (key<a[mid]) hi=mid-1;
			else return mid;
		}
		return -1;
	}
	
	private static int searchRight(int[] a,int key,int lo,int hi) {
		int mid=0;
		while (lo<=hi) {
			mid=lo+(hi-lo)/2;
			if (key>a[mid]) hi=mid-1;
			else if (key<a[mid]) lo=mid+1;
			else return mid;
		}
		return -1;
	}
	
	public static int find(int[] a,int key) {
		int lo=0;
		int hi=a.length-1;
		int mid=0;
		// 为了找到最大值的index
		while (lo<=hi) {
			mid=lo+(hi-lo)/2;
			if (a[mid]==key) return mid;
			else {
				if (mid==0||mid==a.length-1) return -1;// 只有2个数
				if (a[mid]>a[mid-1]&&a[mid]>a[mid+1]) {
					break;
				}else if (a[mid]>a[mid-1]&&a[mid]<a[mid+1]) {
					lo=mid+1;
				}else {
					hi=mid-1;
				}
			}
		}
		int maxValIndex=mid;
		if (key>a[maxValIndex]) return -1;
		if (key<a[0]&&key<a[a.length-1]) return -1;
		int findValue=seaarchLeft(a, key, 0, maxValIndex-1);
		if (findValue==-1)
			findValue=searchRight(a, key, maxValIndex+1,a.length-1 );
		return findValue;
	}
	public static int findFaster(int[] a,int key) {
		int lo=0;
		int hi=a.length-1;
		int mid=0;
		int findValue=-1;
		while (lo<=hi) {
			mid=lo+(hi-lo)/2;
			if (a[mid]==key) return mid;
			//else if (a[mid]>key) {
				if (a[mid]>a[mid-1]&&a[mid]>a[mid+1]) {
					findValue=seaarchLeft(a, key, 0, mid-1);
					if (findValue==-1) 
						findValue=searchRight(a, key, mid+1, a.length-1);
					return findValue;
				}else if (a[mid]>a[mid-1]&&a[mid]<a[mid+1]) {
					lo=mid+1;
				}else {
					hi=mid-1;
				}
			//}else {
			//	findValue=seaarchLeft(a, key, 0, mid-1);
			//	if (findValue==-1) findValue=searchRight(a, key, mid+1, a.length-1);
	//	return findValue;
			}
		
		return -1;
	}
	
	public static void main(String[] args) {
		 int[] a = {0,1,2,3,5,6,7,8,9,3,2,1,0};
	        System.out.println(ClassHomework5.find(a, 2));
	        System.out.println(ClassHomework5.findFaster(a, 2));
	}
}
// {0,1,2,3,5,6,7,8,9,3,2,1,0}