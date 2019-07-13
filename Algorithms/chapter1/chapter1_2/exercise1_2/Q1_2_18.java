package exercise1_2;

import edu.princeton.cs.algs4.*;

public class Q1_2_18 {
	public static void main(String[] args) {
		Accumulator accumulator = new Accumulator();
		while(!StdIn.isEmpty()) {
			accumulator.addDataValue(StdIn.readDouble());
		}
		System.out.println("Mean: " + accumulator.mean());
		System.out.println("Var: " + accumulator.var());
		System.out.println("Stddev: " + accumulator.stddev());
	}
}

class Accumulator{
	private double m;
	private double s;
	private int N;
	public void addDataValue(double x) {
		N++;
		s=s+1.0*(N-1)/N*(x-m)*(x-m);
		m=m+(x-m)/N;
	}
	public double mean() {
		return m;
	}
	public double var() {
		return s/(N-1);
	}
	public double stddev() {
		return Math.sqrt(this.var());
	}
}