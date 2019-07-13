/*
 * Stack with max. 
 * 该题目要求在实现正常stack的push和pop操作外，还需要实现返回maximum的操作
 * Create a data structure that efficiently supports 
 * the stack operations (push and pop) and also a 
 * return-the-maximum operation. Assume the elements 
 * are reals numbers so that you can compare them.
 * 
 * Hint: Use two stacks, one to store all of the items
 *       and a second stack to store the maximums.
 */

import edu.princeton.cs.algs4.Stack;

public class B {
	Stack<Double> num=new Stack<Double>();
	Stack<Double> max=new Stack<Double>();
	
	public boolean isEmpty() {
		return num.isEmpty();
	}
	
	public void push(double item) {
		num.push(item);
		
		if (max.isEmpty()) {
			max.push(item);
		}else {
			double oldnum=max.pop();
			if (item>oldnum)
				max.push(item);
		}
	}
	
	public double pop() {
		return num.pop();
	}
	
	public double maxinum() {
		return max.pop();
	}
	
	public int size() {
		return num.size();
	}
}
