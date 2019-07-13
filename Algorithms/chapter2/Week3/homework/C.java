/* 
 * Shuffling a linked list. 
 * 
 * Given a singly-linked list containing n items, rearrange 
 * the items uniformly at random. Your algorithm should consume 
 * a logarithmic (or constant) amount of extra memory and run 
 * in time proportional to nlogn in the worst case.
 */

package homework;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

public class C<Item extends Comparable<Item>> implements Iterable<Item> {
	private Node first=null;
	private Node last=null;
	private int N=0;
	private class Node{
		Item item;
		Node next;
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{
		private Node current=first;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current!=null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item item=current.item;
			current=current.next;
			return item;
		}
		
	}
	
	private boolean less(Comparable v,Comparable w) {
		return v.compareTo(w)<0;
	}
	
	public void add(Item item) {
		Node node=new Node();
		node.item=item;
		node.next=null;
		if (first==null&&last==null) {
			first=node;
			last=node;
		}else if (first!=null&&first==last) {
			first.next=node;
			last=node;
		}else {
			last.next=node;
			last=node;
		}
	}
	public String toString() {
		Iterator<Item> iterator=iterator();
		String ret=iterator.next().toString();
		while (iterator.hasNext())
			ret+=", "+iterator.next().toString();
		return ret;
	}
	public void mergeSort() {
		first=sort(first);
	}
	private Node sort(Node head) {
		if (head==null||head.next==null) return head;
		Node slow=head;
		Node fast=head;
		while (fast.next!=null&&fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		Node left=head;
		Node right=slow.next;
		slow.next=null;
		left=sort(left);
		right=sort(right);
		return merge(left, right);
	}
	private Node merge(Node left,Node right) {
		Node aux=new Node();
		Node l=left;
		Node r=right;
		Node current=aux;
		while (l!=null&&r!=null) {
			int rand=StdRandom.uniform(2);
			if (rand==0) {
				current.next=l;
				current=current.next;
				l=l.next;
			}else {
				current.next=r;
				current=current.next;
				r=r.next;
			}
		}
		if (l!=null) current.next=l;
		else if (r!=null) current.next=r;
		return aux.next;
	}
	public static void main(String[] args) {
		C<Integer> c=new C<Integer>();
		c.add(1);
		c.add(2);
		c.add(11);
		c.add(9);
		c.add(10);
		c.add(4);
		c.add(7);
		System.out.println(c);
		c.mergeSort();
		System.out.println(c);
	}
}
