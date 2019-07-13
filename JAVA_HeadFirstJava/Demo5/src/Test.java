import java.util.ArrayList;

class Test{
	public static void main(String[] args) {
		ArrayList<String> myList1 = new ArrayList<String>();
		String[] myList2=new String[2];
		String a1 = new String("whoohoo1");
		String a2 = new String("whoohoo2");
		String b1 = new String("Frog1");
		String b2 = new String("Frog2");
		
		myList1.add(a1);
		myList2[0]=a2;
		myList1.add(b1);
		myList2[1]=b2;
		
		int theSize1=myList1.size();
		int theSize2=myList2.length;
		
		Object o1=myList1.get(1);
		String o2=myList2[1];
		
		myList1.remove(1);
		myList2[0]=null;
		
		boolean isIn1=myList1.contains(b1);
		boolean isIn2=false;
		for (String item:myList2) {
			if (b2.equals(item)) {
				isIn2=true;
				break;
			}			
		}
		System.out.println(isIn1+" "+isIn2);
		System.out.println(o1+" "+o2);
		System.out.println(theSize1+" "+theSize2);
	}
}

