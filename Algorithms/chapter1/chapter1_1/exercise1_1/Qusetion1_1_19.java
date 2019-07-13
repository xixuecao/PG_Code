package exercise1_1;

import edu.princeton.cs.algs4.StdOut;

public class Qusetion1_1_19 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			StdOut.println(i+" "+F(i));
		}
	}
	public static long F(int N){
		if (N==0) return 0;
		if (N==1) return 1;
		return F(N-1)+F(N-2);
	}
}
