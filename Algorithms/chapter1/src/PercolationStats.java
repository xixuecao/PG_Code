import edu.princeton.cs.algs4.*;

public class PercolationStats {
	private final int t;
	private final double[] fractions;
	
	private double mean;
	private double stddev;
	public PercolationStats(int n, int trials) {
		// perform trials independent experiments on an n-by-n grid
		if (n<=0||trials<=0)
			throw new IllegalArgumentException("n<=0 or trails<=0");
		t=trials;
		fractions=new double[t];
		for (int i = 0; i < t; i++) {
			Percolation p=new Percolation(n);
			int openNum=0;
			int[] rand=StdRandom.permutation(n*n);
			for (int j : rand) {
				int row=j/n+1;
				int col=j%n+1;
				p.open(row, col);
				openNum++;
				if (openNum>=n&&p.percolates()) 
					break;
			}
			fractions[i]=(double) openNum/(n*n);
		}
		mean=StdStats.mean(fractions);
		stddev=StdStats.stddev(fractions);
	}
	public double mean() {
		// sample mean of percolation threshold
		return mean;
	}
	public double stddev() {
		// sample standard deviation of percolation threshold
		return stddev;
	}
	public double confidenceLo() {
		// low  endpoint of 95% confidence interval
		return mean-1.96*stddev/Math.sqrt(t);
	}
	public double confidenceHi() {
		// high endpoint of 95% confidence interval
		return mean+1.96*stddev/Math.sqrt(t);
	}
	public static void main(String[] args) {
		// test client (described below)
		int n=Integer.parseInt(args[0]);
		int t=Integer.parseInt(args[1]);
		PercolationStats ps=new PercolationStats(n, t);
		System.out.printf("%-25s %s %f \n", "means", "=", ps.mean());
		System.out.printf("%-25s %s %f \n", "stddev", "=", ps.stddev());
		System.out.printf("%-25s %s%f%s%f%s\n", "95% confidence interval", "= [", ps.confidenceLo(), ", ",ps.confidenceHi(), "]");
	}
}
