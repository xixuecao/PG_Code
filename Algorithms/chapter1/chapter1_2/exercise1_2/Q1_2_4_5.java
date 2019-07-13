package exercise1_2;

public class Q1_2_4_5 {
	public static void main(String[] args) {
		// Q1.2.4
		String string1="hello";
		String string2=string1;
		string1="world";
		System.out.println(string1);
		System.out.println(string2);
		// Q1.2.5
		String s="Hello World";
		s.toUpperCase();
		s.substring(6,11);
		System.out.println(s);
		s=s.toUpperCase();
		s=s.substring(6,11);
		System.out.println(s);
	}
}