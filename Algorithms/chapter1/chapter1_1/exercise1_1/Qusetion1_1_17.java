package exercise1_1;

public class Qusetion1_1_17 {
	public static void main(String[] args) {
		System.out.println(exR1(6));	
		}
		
		public static String exR1(int n) {
			String s=exR1(n-3)+n+exR1(n-2)+n;//������ʻ������֣���һ��һ�����
			if (n<=0) return "";
			return s;
		}
}
