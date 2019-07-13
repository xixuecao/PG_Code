/*
 * Queue with two stacks. 
 * 用栈实现队列所有操作
 * Implement a queue with two stacks so that each queue 
 * operations takes a constant amortized number of stack 
 * operations.
 */

import java.util.Iterator;
import edu.princeton.cs.algs4.Stack;

public class A<Item> {
	Stack<Item> inStack=new Stack<Item>();
	Stack<Item> outStack=new Stack<Item>();
	public boolean iaEmpty() {
		if (inStack.isEmpty()&&outStack.isEmpty())
			return true;
		return false;
	}
	
	public int size() {
		return inStack.size()+outStack.size();
	}
	
	public void enqueue(Item item) {
		inStack.push(item);
	}
	
	public Item dequeue() {
		if (outStack.isEmpty()) {
			if (inStack.isEmpty()) return null;
			else {
				Iterator<Item> i=inStack.iterator();
				while (i.hasNext()) {
					outStack.push(i.next());
				}
				return outStack.pop();
			}
		}else {
			return outStack.pop();
		}
	}
}
