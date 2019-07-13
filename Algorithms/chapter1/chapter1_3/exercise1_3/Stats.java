package exercise1_3;
import edu.princeton.cs.algs4.*;

public class Stats {
	public static void main(String[] args) {
		Bag<Double> numbers=new Bag<Double>();
		//this input has a problem, terminate by pressing "Ctrl+Z"
		while (!StdIn.isEmpty()) 
			numbers.add(StdIn.readDouble());
		int N=numbers.size();
		
		double sum=0.0;
		for (Double x : numbers){
			sum+=x;
		}
		double mean=sum/N;
		
		sum=0.0;
		for (Double x : numbers) 
			sum+=(x-mean)*(x-mean);
		double std=Math.sqrt(sum/(N-1));
		
		System.out.println("Mean: "+mean);
		System.out.println("Std dev: "+std);

	}
}
// 100 99 101 120 98 107 109 81 101 90