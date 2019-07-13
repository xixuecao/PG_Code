import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item>{
    private int n;
    private Node first;
    private Node last;
    
    private class Node{
    	Item item;
    	Node next;
    }
    public Deque(){
        // construct an empty deque
    	n=0;
    	first=null;
    }
    public boolean isEmpty(){
        // is the deque empty?
    	return n==0;
    }
    public int size(){
        // return the number of items on the deque
        return n;
    }
    public void addFirst(Item item){
        // add the item to the front
        if (item==null) throw new IllegalArgumentException();
        Node oldfirst=first;
        first=new Node();
        first.item=item;
        if (isEmpty()){
            last=first;
            n++;
        }
        else{
            first.next=oldfirst;
            n++;
        }
    }
    public void addLast(Item item){
        // add the item to the end
        if (item==null) throw new IllegalArgumentException();
        Node oldlast=last;
        last=new Node();
        last.item=item;
        if (isEmpty()){
            first=last;
            n++;
        }
        else{
            oldlast.next=last;
            n++;
        }
    }
    public Item removeFirst(){
        // remove and return the item from the front
        if (isEmpty()) throw new NoSuchElementException();
        Item item=first.item;
        first=first.next;
        if (isEmpty()) last=null;
        n--;
        return item;
    }
    public Item removeLast(){
        // remove and return the item from the end
        if (isEmpty()) throw new NoSuchElementException();
        Item item=last.item;
        if (first == last) {
            return null;
        }
        Node node = first;
        while (node.next != last){
            node = node.next;
        }
        node.next = node.next.next;
        if (isEmpty()) first=null;
        n--;
        return item;
    }
    public Iterator<Item> iterator(){
        // return an iterator over items in order from front to end
        return new ListIterator();
    }
    
    private class ListIterator implements Iterator<Item>{
        private Node current=first;
        public boolean hasNext(){
            // TODO Auto-generated method stub
            return current!=null;
        }
        public Item next(){
            // TODO Auto-generated method stub
            if (current==null)
                throw new NoSuchElementException("there are no more items!");
            Item item=current.item;
            current=current.next;
            return item;
        }
        public void remove(){
            throw new UnsupportedOperationException("remove");
        }
    }
    public static void main(String[] args){
        // unit testing (optional)
        Deque<String> queue = new Deque<String>();
        System.out.println(queue.size());
        queue.addFirst("a");
        queue.addFirst("b");      
        queue.addLast("c"); 
        queue.addFirst("d");
        queue.addLast("e");
        System.out.println(queue.size());
        Iterator<String> iter = queue.iterator();
        while (iter.hasNext())
            System.out.println(iter.next());
    }
}