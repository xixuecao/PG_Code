package exercise1_3;

import java.util.Iterator;

public class ResizingArrayQueue<Item> {
	private Item[] a=(Item[]) new Object[1];
	private int head=0;
	private int tail=0;
	
	public boolean isEmpty() {return (tail-head)==0;}
	public int size() {return (tail-head);}
	
	private void resize(int max) {
		int j=0;
		Item[] item=(Item[]) new Object[max];
		for (int i = head; i < tail; i++)
			item[j++]=a[i];
		a=item;
		head=0;
		tail=j;
	}
	public void enqueue(Item item) {
		if (tail==a.length) 
			resize(2*a.length);
		a[tail++]=item;
	}
	public Item dequeue() {
		Item item=a[head];
		a[head]=null;
		head++;
		if (size()>0&&size()==a.length/4) 
			resize(a.length/2);
		return item;
	}
}
