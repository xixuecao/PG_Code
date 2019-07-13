package exercise1_2;

public class Q1_2_6 {
	public static void main(String[] args) {
		String s="ACTGACG";
		System.out.println(s);
		String t="TGACGAC";
		System.out.println(t);
		if (s.length()==t.length()&&s.concat(s).indexOf(t)>=0) {
			System.out.println("s="+s+" and t="+t+" is circular rotation");
		}else {
			System.out.println("s="+s+" and t="+t+" is not circular rotation");
		}
	}
}
