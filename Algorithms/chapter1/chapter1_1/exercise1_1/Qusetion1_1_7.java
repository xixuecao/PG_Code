
package exercise1_1;

public class Qusetion1_1_7 {
	public static void main(String[] args) {
		double t=9.0;
		while (Math.abs(t-9.0/t)>.001)
			t=(9.0/t+t)/2.0;
		System.out.printf("a. "+"%.5f\n",t);
		
		int sum1=0;
		for (int i =1; i <1000; i++)
			for (int j = 0; j <i; j++)
				sum1++;
		System.out.println("b. "+sum1);
		
		int sum2=0;
		for (int i = 1; i < 1000;i*=2)
			for (int j = 0; j < 1000; j++)
				sum2++;
		System.out.println("c. "+sum2);
	}
}
