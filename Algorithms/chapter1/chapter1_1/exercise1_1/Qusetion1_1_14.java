package exercise1_1;

public class Qusetion1_1_14 {
	public static void main(String[] args) {
		int N=Integer.parseInt(args[0]);
		System.out.println(lg(N));
	}
	
	static int lg(int N){
		int lg=0;
		for (int i = 0; i < N; i++) {
			if (Math.pow(2,i)<N&&Math.pow(2,i+1)>N) {
				lg=i;
				break;
			}
		}	
		return lg;
	}
}
