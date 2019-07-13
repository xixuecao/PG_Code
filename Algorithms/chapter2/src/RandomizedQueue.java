import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] a;
	private int n;
	
	@SuppressWarnings("unchecked")
	public RandomizedQueue() {
		// construct an empty randomized queue
		n=0;
		a=(Item[]) new Object[1];
	}
	public boolean isEmpty() {
		// is the queue empty?
		return n==0;
	}
	public int size() {
		// return the number of items on the queue
		return n;
	}
	public void enqueue(Item item) {
		// add the item
		if (item == null)
            throw new IllegalArgumentException("the item is null!");
		if (n==a.length) resize(2*a.length);
		a[n++]=item;
	}
	public Item dequeue() {
		// remove and return a random item
		if (size() == 0)
            throw new NoSuchElementException("the RandomizeQueue is empty!");
		int r=StdRandom.uniform(0,n);
		n--;
		Item item=a[r];
		a[r]=a[n];
		a[n]=null;
		if (size()>0&&size()==a.length/4) 
			resize(a.length/2);
		return item;
	}
	
	private void resize(int cap) {
		@SuppressWarnings("unchecked")
		Item[] item=(Item[]) new Object[cap];
		for (int i = 0; i < size(); i++)
			item[i]=a[i];
		a=item;
	}
	
	public Item sample() {
		// return (but do not remove) a random item
		if (size() == 0)
            throw new NoSuchElementException("the RandomizeQueue is empty!");
		return a[StdRandom.uniform(0,size())];
	}
	public Iterator<Item> iterator() {
		// return an independent iterator over items in random order
		return new RandomIterator();
	}
	private class RandomIterator implements Iterator<Item>{
		private int rank;
		private Item[] array;
		@SuppressWarnings("unchecked")
		public RandomIterator() {
			// TODO Auto-generated constructor stub
			rank=size();
			array=(Item[]) new Object[rank];
			for (int i = 0; i < rank; i++) {
				array[i]=a[i];
			}
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return rank>0;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if (rank == 0)
				throw new NoSuchElementException("there are no more items!");
			int r = StdRandom.uniform(0, rank);
            rank--;
            Item item = array[r];
            array[r] = array[rank];
            array[rank] = item; // the chosen one put into last
            return item;
		}
		public void remove() {
			throw new UnsupportedOperationException("remove");
		}
	}
	public static void main(String[] args) {
		// unit testing (optional)
		 RandomizedQueue<String> rq = new RandomizedQueue<String>();
	        rq.enqueue("a");
	        rq.enqueue("b");
	        rq.enqueue("c");
	        rq.enqueue("d");
	        rq.enqueue("e");
	        rq.enqueue("f");
	        rq.enqueue("g");
	        rq.dequeue();
	        Iterator<String> iter1 = rq.iterator();
	        Iterator<String> iter2 = rq.iterator();
	        while (iter1.hasNext()) {
	            System.out.print(iter1.next() + ",");
	        }
	        System.out.println();
	        while (iter2.hasNext()) {
	            System.out.print(iter2.next() + ",");
	        }
	        System.out.println();
	}
}