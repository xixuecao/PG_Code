// �㷨1.2 ��ѹ��ջ������ʵ�֣�
package exercise1_3;
import java.util.Iterator;
import edu.princeton.cs.algs4.*;

public class Stack<Item> implements Iterable<Item>{
	private Node first;  //ջ��
	private int N;       //Ԫ������
	private class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty() {
		return first==null;//����N==0
	}
	public int size() {
		return N;
	}
	public void push(Item item) {
		// ��ӵ���ͷ ջ��
		Node oldfirst=first;
		first=new Node();
		first.item=item;
		first.next=oldfirst;
		N++;
	}
	public Item pop() {
		// �ӱ�ͷɾ��  ջ��
		Item item=first.item;
		first=first.next;
		N--;
		return item;
		//iterator()ʵ�ּ��㷨1.4
	}
	public Item peek() throws Exception {
		//����Ԫ�ص���ɾ��
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
	 * �˶δ���Ϊ֧�ֵ�����
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
//��ʱ��֧�ֵ�����Ҫ֧��������㷨1.4��ΪBag�������͸����ļӴִ���
//����   to be or not to - be - - that - - - is
//���   to be not that or be (2 left on stack)