package exercise1_4;

import edu.princeton.cs.algs4.In;

public class ThreeSum {
	public static int count(int[] a) {
		int cnt=0;
		for (int i = 0; i < a.length; i++)
			for (int j = i+1; j < a.length; j++)
				for (int k = j+1; k < a.length; k++)
					if ((long)a[i]+a[j]+a[k]==0) // Q1.4.1²ÉÓÃlong±ÜÃâÒç³ö
						cnt++;
		return cnt;
	}
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			int[] a=In.readInts(args[i]);
			Stopwatch stopwatch=new Stopwatch();
			
			System.out.print(a.length+": "+count(a)+" triples");
			System.out.println(stopwatch.elapsedTime()+" seconds");
		}
		
	}
}

