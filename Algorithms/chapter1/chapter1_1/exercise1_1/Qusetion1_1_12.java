package exercise1_1;

public class Qusetion1_1_12 {
	public static void main(String[] args) {
		int[] a=new int[10];
		for (int i = 0; i < a.length; i++)
			a[i]=9-i;
		for (int i = 0; i < a.length; i++)
			a[i]=a[a[i]];
		for (int i = 0; i < a.length; i++)
			System.out.println(i);
	}
}
