package exercise1_3;
import edu.princeton.cs.algs4.*;
public class Q1_3_10 {
	
	    public static void main(String[] args) {
	        Stack<String> stack = new Stack<String>();
	        while (!StdIn.isEmpty()) {
	            String s = StdIn.readString();
	            if      (s.equals("+")) stack.push(s);
	            else if (s.equals("*")) stack.push(s);
	            else if (s.equals(")")) StdOut.print(stack.pop() + " ");
	            else if (s.equals("(")) StdOut.print("");
	            else                    StdOut.print(s + " ");
	        }
	        StdOut.println();
	    }
}
// 2*3/(2-1)+3*(4-1)