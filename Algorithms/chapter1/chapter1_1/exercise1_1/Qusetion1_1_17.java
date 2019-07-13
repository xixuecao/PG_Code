package exercise1_1;

public class Qusetion1_1_17 {
	public static void main(String[] args) {
		System.out.println(exR1(6));	
		}
		
		public static String exR1(int n) {
			String s=exR1(n-3)+n+exR1(n-2)+n;//不会访问基础部分，在一层一层进入
			if (n<=0) return "";
			return s;
		}
}
