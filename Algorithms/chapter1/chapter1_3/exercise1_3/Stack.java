// 算法1.2 下压堆栈（链表实现）
package exercise1_3;
import java.util.Iterator;
import edu.princeton.cs.algs4.*;

public class Stack<Item> implements Iterable<Item>{
	private Node first;  //栈顶
	private int N;       //元素数量
	private class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty() {
		return first==null;//或者N==0
	}
	public int size() {
		return N;
	}
	public void push(Item item) {
		// 添加到表头 栈顶
		Node oldfirst=first;
		first=new Node();
		first.item=item;
		first.next=oldfirst;
		N++;
	}
	public Item pop() {
		// 从表头删除  栈顶
		Item item=first.item;
		first=first.next;
		N--;
		return item;
		//iterator()实现见算法1.4
	}
	public Item peek() throws Exception {
		//返回元素但不删除
		if (isEmpty())
			throw new Exception("Stack Underflow");
		return first.item;
	}
	public static <Item>Stack<Item> copy(Stack<Item> stack) {
		Stack<Item> temp=new Stack<Item>();
		for (Item item : stack) {
			temp.push(item);
		}
		Stack<Item> result=new Stack<Item>();
		for (Item item : temp) {
			result.push(item);
		}
		return result;	
	}
	
	/**
	 * 此段代码为支持迭代区
	 */
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{
		private Node current = first;
		public boolean hasNext() {
			return current != null;
		}
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		public void remove() {
		}
	}
	
	
	public static void main(String[] args) {
		Stack<String> s=new Stack<String>();
		while (!StdIn.isEmpty()) {
			String item=StdIn.readString();
			if (!item.equals("-")) {
				s.push(item);
			}else if (!s.isEmpty()) {
				System.out.print(s.pop()+" ");
			}
		}
		System.out.println("("+s.size()+" left on stack)");
	}
}
//暂时不支持迭代，要支持需添加算法1.4中为Bag数据类型给出的加粗代码
//输入   to be or not to - be - - that - - - is
//输出   to be not that or be (2 left on stack)