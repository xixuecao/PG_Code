package exercise1_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Qusetion1_1_28 {
	public static void main(String[] args) {
		int[] whitelist={2,4,1,35,7,4,2,1,6,7,43,1};
		Arrays.sort(whitelist);
		for (int i = 0; i < whitelist.length; i++) {
			System.out.print(whitelist[i]+" ");
		}
		System.out.println();
		int N=repeatNum(whitelist);
		System.out.println("repeatNumber="+N);
		Integer[] res1=copyArray(whitelist);
		int[] res2=copyArray(whitelist, N);
		for (int i = 0; i < res1.length; i++) {
			System.out.print(res1[i]+" ");	
		}
		System.out.println();
		for (int i = 0; i < res1.length; i++) {
			System.out.print(res2[i]+" ");
		}
	}
	public static int repeatNum(int[] a) {
		int count=0;
		for (int i = 0; i < a.length-1; i++) {
			if (a[i]==a[i+1]) {
				count++;
			}
		}
		return count;
	}
	public static int[] copy(int[] original, int repeatedCnt) {
	    int[] res = new int[original.length - repeatedCnt];
	    int cntIdx = 0;
	    res[cntIdx ++] = original[0];
	    for(int i = 1; i < original.length; ++i)
	        if(original[i] == original[i-1])
	            continue;
	        else
	            res[cntIdx ++] = original[i];
	    return res;
	}
	public static int[] copyArray(int[] a,int repeatNum) {
		int[] copyArray=new int[a.length-repeatNum];
		int count=1;
		copyArray[0]=a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i]!=a[i-1]) {
				copyArray[count]=a[i];
				count++;
			}
		}
		return copyArray;
	}
	public static Integer[] copyArray(int[] a) {
		ArrayList<Integer> list=new ArrayList<>();
		for (int i = 0; i <a.length-1; i++) {
			if (a[i]!=a[i+1]) {
				list.add(a[i]);
			}		
		}
		Integer[] newArray=list.toArray(new Integer[list.size()]);
		return newArray;
	}
}
