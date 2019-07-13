package exercise1_4;

import java.util.Arrays;
import java.util.Iterator;

import edu.princeton.cs.algs4.In;
import exercise1_1.BinarySearch;

public class ThreeSumFast {
	public static int count(int[] a) {
		Arrays.sort(a);
		int cnt=0;
		for (int i = 0; i < a.length; i++)
			for (int j = i+1; j < a.length; j++)
				if (BinarySearch.rank(a, -a[i]-a[j])>j)// �����ҳ���������������������һ��ѭ�����棬�����ظ�
					cnt++;
		return cnt;
	}
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			int[] a=In.readInts(args[i]);
			Stopwatch stopwatch=new Stopwatch();
			
			System.out.print(a.length+": "+count(a)+" triples ");
			System.out.println(stopwatch.elapsedTime()+" seconds");
		}
		
	}
}
