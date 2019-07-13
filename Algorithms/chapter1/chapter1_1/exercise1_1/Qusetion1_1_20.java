package exercise1_1;

public class Qusetion1_1_20 {
	public static void main(String[] args) {
		System.out.println(ln(5));
	}
	public static double ln(int N) {
		int pro=1;
		for (int i = 2; i <= N; i++) {
			pro*=i;
		}
		return Math.log(pro);
	}
}
