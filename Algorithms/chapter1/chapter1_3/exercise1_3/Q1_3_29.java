package exercise1_3;

public class Q1_3_29<Item> {
	// 这里是2个实例变量而不是对象；
	private class Node{
		Item item;
		Node next;
		public Node(Item item) {
			this.item=item;
		}
	}
	private Node last;
	public void enqueue(Item item) {
		//刚开始last为空,那么将其初始化,并指向自己
		Node node=new Node(item);
		if (last==null) {
			last=node;
			last.next=last;
		}else {
			node.next =last.next;
			last.next=node;

			last=node;
		}
	}
	public Item dequeue() {
		//如果last为空,直接抛出异常
		if (last==null) {
			throw new NullPointerException();
		}
		Node first=last.next;
		
		if (first==last) {
			//如果first与last相等,说明last.next = last,即链表中只剩一个结点
            //将其置空
			last=null;
		}else {
			//不然更新last的后置结点,即first结点
			last.next=first.next;
		}
		return first.item;
	}
}
