package exercise1_1;

public class Qusetion1_1_30 {
	public static void main(String[] args){
		int N=5;
		boolean[][] array=boolArray(N);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static int gcd(int p, int q) {
	    if(q == 0)
	        return p;
	    int r = p % q;
	    return gcd(q, r);
	}
	public static boolean[][] boolArray(int N) {
		boolean[][] array=new boolean[N][N];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				array[i][j]=true;
			}
		}
		for (int i =1; i <array.length; i++) {
			for (int j =1; j <array.length; j++) {
				if (gcd(i, j)==1) {
					array[i][j]=true;
				}else {
					array[i][j]=false;
				}
				
			}
			
		}
		return array;
	}
}
