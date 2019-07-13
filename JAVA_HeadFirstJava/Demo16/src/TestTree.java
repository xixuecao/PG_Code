import java.util.*;

public class TestTree {
	class Book implements Comparable {
		String title;
		public Book(String t) {
			title=t;
		}
		public int compareTo(Object b) {
			Book book = (Book) b;// TODO Auto-generated method stub
			return (title.compareTo(book.title));
		}
		
	}
	
	public void  go() {
		Book b1 = new Book("How Cats Work");
		Book b2 = new Book("Remix your Body");
		Book b3 = new Book("Finding Emo");
		
		TreeSet<Book> tree = new TreeSet<Book>();
		tree.add(b1);
		tree.add(b2);
		tree.add(b3);
		
		System.out.println(tree);
	}
	
	public static void main(String[] args) {
		new TestTree().go();
	}
}
