package exercise1_2;
import edu.princeton.cs.algs4.*;
public class Q1_2_10 {
	private final String name;
	private int count;
	private int num;
	private int N;
	private int max;
	public Q1_2_10(int n,int max){
		name="VisualCounter";
		count=0;
		num=0;
		N=n;
		this.max=max;
		StdDraw.setXscale(0,N);
		StdDraw.setYscale(-max,max);
		StdDraw.setPenRadius(0.01);
		StdDraw.point(0,0);
	}
	public void increment() {
		if (num>=N) {
			System.out.println("Operate too much!");
			return;
		}
		if (count>=max) {
			System.out.println("Exceed the max!");
			return;
		}
		count++;
		num++;
		StdDraw.point(num, count);
	}
	public void decrement() {
		if (num>=N) {
			System.out.println("Operate too much!");
			return;
		}
		if (count<=-max) {
			System.out.println("Exceed the max!");
			return;
		}
		count--;
		num++;
		StdDraw.point(num, count);
	}
	public int tally() {
		return count;
	}
	public String toString() {
		return count+" "+name;
	}
	public static void main(String[] args) {
		Q1_2_10 counter=new Q1_2_10(35, 20);
		for (int i = 0; i < 10; i++) {
			counter.increment();
		}
		for (int i = 0; i < 15; i++) {
			counter.decrement();
		}
		for (int i = 0; i < 10; i++) {
			counter.increment();
		}
		System.out.println(counter);
	}
	
}
