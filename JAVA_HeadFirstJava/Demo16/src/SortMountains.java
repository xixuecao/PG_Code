import java.util.*;

public class SortMountains {
	LinkedList<Mountain> mtn = new LinkedList<Mountain>();
	
	class NameCompare implements Comparator<Mountain> {
		public int compare(Mountain one, Mountain two) {
			return one.Name.compareTo(two.Name);
		}
	}
	
	class HeightCompare implements Comparator<Mountain> {
		public int compare(Mountain one, Mountain two) {
			return (two.Height-one.Height);
		}
	}
	
	public static void main(String [] args) {
		new SortMountains().go();
	}
	
	public void go() {
		mtn.add(new Mountain("Longs", 14255));
		mtn.add(new Mountain("Elbert", 14433));
		mtn.add(new Mountain("Maroon", 14156));
		mtn.add(new Mountain("Castle", 14265));
		System.out.println("as entered:\n" + mtn);
		NameCompare nc = new NameCompare();
		Collections.sort(mtn,nc);;
		System.out.println("by name:\n" + mtn);
		HeightCompare hc = new HeightCompare();
		Collections.sort(mtn,hc);
		System.out.println("by height:\n" + mtn);
	}
}
