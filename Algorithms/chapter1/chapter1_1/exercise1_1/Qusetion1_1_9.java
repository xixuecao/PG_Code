package exercise1_1;

public class Qusetion1_1_9 {
	public static void main(String[] args) {
		String s="";
		int N=Integer.parseInt(args[0]);
		for (int i=N; i>0; i/=2)
			s=(i%2)+s;
		System.out.println(s);
	}
}
