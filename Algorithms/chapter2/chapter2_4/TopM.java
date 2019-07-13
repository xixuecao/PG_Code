// 一个优先列队的用例

/*
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
*/

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Transaction;

public class TopM {
	public static void main(String[] args) {
		int M=Integer.parseInt(args[0]);
		MinPQ1<Transaction> pq=new MinPQ1<Transaction>(M+1);
		In in=new In(StdIn.readLine());
		while (in.hasNextLine()) {
			pq.insert(new Transaction(in.readLine()));
			if (pq.size()>M) pq.delMin();
		}
		
		Stack<Transaction> stack=new Stack<Transaction>();
		while (!pq.isEmpty()) stack.push(pq.delMin());
		for (Transaction t : stack) System.out.println(t);
	}
}
/*
 * java自带输入
public class TopM {
	public static void main(String[] args) throws FileNotFoundException {
		int M=Integer.parseInt(args[0]);
		MinPQ<Transaction> pq=new MinPQ<Transaction>(M+1);
		Scanner scanner=new Scanner(new FileInputStream(StdIn.readString()));
		while (scanner.hasNextLine()) {
			pq.insert(new Transaction(scanner.nextLine()));
			if (pq.size()>M) pq.delMin();
		}
		
		Stack<Transaction> stack=new Stack<Transaction>();
		while (!pq.isEmpty()) stack.push(pq.delMin());
		for (Transaction t : stack) System.out.println(t);
	}
}
 */
// F:\Algorithms\Week4\Data\tinyBatch.txt