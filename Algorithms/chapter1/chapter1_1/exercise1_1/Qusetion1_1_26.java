package exercise1_1;

public class Qusetion1_1_26 {
	public static void main(String[] args) {
		int a=5,b=4,c=8,t;
		if (a>b) {t=a;a=b;b=t;}
		if (a>c) {t=a;a=c;c=t;}
		if (b>c) {t=b;b=c;c=t;}
		System.out.println(" "+a+b+c);
	}
}
