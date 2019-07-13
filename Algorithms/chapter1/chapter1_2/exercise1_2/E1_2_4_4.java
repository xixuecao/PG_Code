package exercise1_2;
import edu.princeton.cs.algs4.*;

public class E1_2_4_4 {
	public static void main(String[] args) {
		int T= Integer.parseInt(args[0]);
		VisualAccumulator a=new VisualAccumulator(T, 1.0);
		for (int i = 0; i < T; i++)
			a.addDataValue(StdRandom.random());
		StdOut.println(a);
	}
}

class VisualAccumulator{
	public VisualAccumulator(int trails,double max){
		StdDraw.setXscale(0,trails);
		StdDraw.setYscale(0,max);
		StdDraw.setPenRadius(0.005);
	}
	
	private double total;
	private int N;
	
	public void addDataValue(double val) {
		N++;
		total+=val;
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.point(N, val);
		StdDraw.setPenColor(StdDraw.BOOK_RED);
		StdDraw.point(N, total/N);
	}
	
	public double mean() {
		return total/N;
	}
	
	public String toString(){
		return "Mean ("+N+" value ):"+mean();
	}
}
