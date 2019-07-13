// Ëã·¨1.4 ±³°ü
package exercise1_3;
import java.util.Iterator;
public class Bag<Item> implements Iterable<Item>{
	private Node first;
	private int n;
	private class Node{
		Item item;
		Node next;
	}
    public int size() {
        return n;
    }
	public void add(Item item) {
		Node oldfirst=first;
		first=new Node();
		first.item=item;
		first.next=oldfirst;
		n++;
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
}
