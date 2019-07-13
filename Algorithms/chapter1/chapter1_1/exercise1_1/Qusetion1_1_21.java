package exercise1_1;
import edu.princeton.cs.algs4.*;
public class Qusetion1_1_21 {
	public static void main(String[] args) {
		while (StdIn.hasNextLine()) {
			String name=StdIn.readString();
			int m=StdIn.readInt();
			int n=StdIn.readInt();
			StdOut.printf("%8s | %8d | %8d | %8.3f", name,m,n,(m*1.0)/n);
		}
	}
}
