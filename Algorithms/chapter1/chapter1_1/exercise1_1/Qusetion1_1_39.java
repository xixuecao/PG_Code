package exercise1_1;
import edu.princeton.cs.algs4.*;
public class Qusetion1_1_39 {
	/**
	 * ���س���Ϊlength�����6λ����������
	 * @param length    ���鳤��
	 * @return  ���6λ����������
	 */
	public static int[] ramdomArray(int N) {
		int[] arr=new int[N];
		for (int i = 0; i < N; i++) {
			arr[i]=StdRandom.uniform(100000, 1000000);
		}
		return arr;
	}
	/**
	 * �ݹ���ҹؼ��ʵ�����
	 * @param key   �ؼ���
	 * @param arr   ����
	 * @param low   ��ǰ���Ҷε���ʼ����
	 * @param high  ��ǰ���Ҷε���������
	 * @return  �����ҵ��򷵻عؼ���key������ֵ���Ҳ����򷵻�-1
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
	 * ���ҹؼ�key�Ƿ�������arr��
	 * @param key   �ؼ���
	 * @param arr   ����
	 * @return  ���ҵ��򷵻�����ֵ�����򷵻�-1
	 */
	public static int binarySearch(int key,int[] arr) {
		return rank(key, arr,0, arr.length-1);
	}
	/**
	 * ͳ�����������е���ͬԪ�ظ���
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
	 * ���ƥ��
	 * @param T ����
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
