// �㷨1.3 �Ƚ��ȳ�����
package exercise1_3;
import java.util.Iterator;
import edu.princeton.cs.algs4.StdIn;

public class Queue<Item> implements Iterable<Item>{
	private Node first;
	private Node last;
	private int N;
	private class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty() {
		return first==null;
	}
	public int size() {
		return N;
	}
	public void enqueue(Item item) {
		// ��ӵ���β
		Node oldlast=last;
		last=new Node();
		last.item=item;
		if (isEmpty()) first=last;
		else oldlast.next=last;
		N++;
	}
	public Item dequeue() {
		// �ӱ�ͷɾ��
		Item item=first.item;
		first=first.next;
		if (isEmpty()) last=null;
		N--;
		return item;
		//iterator()ʵ�ּ��㷨1.4
	}
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{
		private Node current=first;
		public boolean hasNext() {
			return current!=null;
		}
		public Item next() {
			Item item=current.item;
			current=current.next;
			return item;
		}
		public void remove() {
		}
	}
	public static void main(String[] args) {
		Queue<String> q=new Queue<String>();
		while (!StdIn.isEmpty()) {
			String item=StdIn.readString();
			if (!item.equals("-")) {
				q.enqueue(item);
			}else if (!q.isEmpty()) {
				System.out.print(q.dequeue()+" ");
			}
		}
		System.out.println("("+q.size()+" left on queue)");
	}
}
//��ʱ��֧�ֵ�����Ҫ֧��������㷨1.4��ΪBag�������͸����ļӴִ���
//����   to be or not to - be - - that - - - is
//���   to be not that or be (2 left on stack)