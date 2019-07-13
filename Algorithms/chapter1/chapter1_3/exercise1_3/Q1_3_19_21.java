package exercise1_3;
public class Q1_3_19_21 {
	private class Node{
		String item;
		Node next;
	}
	private Node first;
	// 19Ã‚
	public void deleteLastNode() {
		
		Node current=first;
		if (current==null) return;
		
		Node next=current.next;
		if (next==null) first=null;
		
		while (next.next!=null) {
			current=next;
			next=next.next;
		}
		current.next=null;
	}
	//20Ã‚
	public void delete(int k) {
		Node current=first;
		if (k<0||first==null) return;
		if (k==1) first=first.next;
		k--;
		while (current!=null&&k!=0) {
			current=current.next;	
			k--;
		}
		if (k!=0||current==null) {
			return;
		}else {
			current=current.next;
		}
	}
	// 21Ã‚
	public boolean find(Node node,String key) {
		for (Node x= first; x!=null; x=x.next) {
			if (x.item.equals(key)) {	
				return true;
			}
		}
		return false;
	}
}
