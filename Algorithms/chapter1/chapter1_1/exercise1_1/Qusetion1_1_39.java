package exercise1_1;
import edu.princeton.cs.algs4.*;
public class Qusetion1_1_39 {
	/**
	 * 返回长度为length的随机6位正整数数组
	 * @param length    数组长度
	 * @return  随机6位正整数数组
	 */
	public static int[] ramdomArray(int N) {
		int[] arr=new int[N];
		for (int i = 0; i < N; i++) {
			arr[i]=StdRandom.uniform(100000, 1000000);
		}
		return arr;
	}
	/**
	 * 递归查找关键词的索引
	 * @param key   关键字
	 * @param arr   数组
	 * @param low   当前查找段的起始索引
	 * @param high  当前查找段的最终索引
	 * @return  若查找到则返回关键字key的索引值，找不到则返回-1
	 */
	public static int rank(int key,int[] arr,int low,int high) {
		
		if (low>high) 
			return -1;
		int mid=low+((high-low)>>1);
		if (key<arr[mid]) 
			return rank(key, arr,low ,mid-1);
		else if (key>arr[mid])
			return rank(key, arr, mid+1, high);
		else
			return mid;
	}
	/**
	 * 查找关键key是否在数组arr中
	 * @param key   关键字
	 * @param arr   数组
	 * @return  若找到则返回索引值，否则返回-1
	 */
	public static int binarySearch(int key,int[] arr) {
		return rank(key, arr,0, arr.length-1);
	}
	/**
	 * 统计两个数组中的相同元素个数
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public static int count(int[] arr1,int[] arr2) {
		int cnt=0;
		for (int i = 0; i < arr1.length; i++) {
			int idex=binarySearch(arr1[i], arr2);
			if (-1!=idex)
				++cnt;
		}
		return cnt;
	}
	/**
	 * 随机匹配
	 * @param T 次数
	 */
	public static void ramdomMacth(int T) {
		for (int N =1000; N <=1000000; N*=10) {
			int cnt=0;
			for (int i = 0; i < T; i++) {
				int[] arr1=ramdomArray(N);
				int[] arr2=ramdomArray(N);
				cnt+=count(arr1, arr2);
			}
			double avg=1.0* cnt /N;
			StdOut.println(N+"  "+avg);
		}
	}
	public static void main(String[] args) {
		ramdomMacth(100);
	}
}
