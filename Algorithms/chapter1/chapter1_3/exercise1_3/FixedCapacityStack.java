package exercise1_3;

import edu.princeton.cs.algs4.StdIn;

public class FixedCapacityStack<Item> {
	private Item[] a; //stack entries
	private int N;    //size

	public FixedCapacityStack(int cap){a=(Item[])new Object[cap];}
	public boolean isEmpty() {return N==0;}
	public int size() {return N;}
	public void push(Item item) {a[N++]=item;}
	public Item pop() {return a[--N];}
	
	public static void main(String[] args) {
		FixedCapacityStack<String> s=new FixedCapacityStack<String>(100);
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