package exercise1_3;

import edu.princeton.cs.algs4.StdIn;

public class FixedCapacityStackOfStrings {
	private String[] a; //stack entries
	private int N; 
	
	public FixedCapacityStackOfStrings(int cap){a=new String[cap];}
	public boolean isEmpty() {return N==0;}
	public boolean isFull() {return N==a.length;}
	public int size() {return N;}
	public void push(String item) {a[N++]=item;}
	public String pop() {return a[--N];}
	
	public static void main(String[] args) {
		FixedCapacityStackOfStrings s=new FixedCapacityStackOfStrings(100);	
		while (!StdIn.isEmpty()) {
			String item=StdIn.readString();
			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty())
				System.out.print(s.pop()+" ");
		}
		System.out.println("("+s.size()+" left on stack)");
	}
}

// ‰»Î   to be or not to - be - - that - - - is
// ‰≥ˆ   to be not that or be (2 left on stack)

