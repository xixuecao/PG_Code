package exercise1_4;
import edu.princeton.cs.algs4.StdRandom;

public class DoublingRatio {
	public static double timeTrial(int N) {
		int MAX=1000000;
		int[] a=new int[N];
		for (int i = 0; i < a.length; i++)
			a[i]=StdRandom.uniform(-MAX,MAX);
		Stopwatch timer=new Stopwatch();
		int cnt=ThreeSum.count(a);
		return timer.elapsedTime();
	}
	public static void main(String[] args) {
		double prev=timeTrial(125);
		for (int N=250;true;N+=N){
			double time=timeTrial(N);
			System.out.println(N+" "+time+" "+time/prev);
			prev=time;
		}
	}
}
