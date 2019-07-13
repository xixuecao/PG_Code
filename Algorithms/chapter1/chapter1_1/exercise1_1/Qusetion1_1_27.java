package exercise1_1;
import edu.princeton.cs.algs4.*;
public class Qusetion1_1_27 {
	
	public static void main(String[] args) {
		int N=100;
		int k=50;
		double p=0.25;	
		System.out.println(binomial(N,k,p));
		System.out.println(c);
	}
	static Counter c=new Counter("Call");
	public static double binomial(int N,int k,double p) {
		double[][] a=new double[N+1][k+1];
		for (int i = 0; i < N+1; i++) {
			for (int j = 0; j < k+1; j++) {
				a[i][j]=-1;
			}
		}
		return binomial(a, N, k, p, c);
	}
	public static double binomial(double[][] a,int N,int k,double p,Counter c) {
		if (N==0&&k==0) {return 1.0;}
		if (N<0||k<0) {return 0.0;}
		if (a[N][k]==-1) {
			c.increment();
			a[N][k]=(1.0-p)*binomial(a,N-1, k, p,c)+p*binomial(a,N-1, k-1, p,c);
		}
		return a[N][k];
	}
	
}

