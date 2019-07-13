package exercise1_1;

public class Qusetion1_1_11 {
	public static void main(String[] args) {
		boolean[][] array={{true,false,true,true,false},{false,false,true},{true,false,true}};
		System.out.print("  ");
		for (int i = 0; i <arraycolumnmax(array) ; i++) {
			System.out.print(i+1+" ");
		}
		System.out.println();
		for (int i = 0; i < array.length; ++i) {
			System.out.print(i+1+" ");
			for (int j = 0; j < array[i].length; ++j) {
				if (array[i][j]==true) {
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		
	}
	public static int arraycolumnmax(boolean[][] b) {
		int length=b[0].length;
		for (int i = 0; i < b.length; i++) {
			if (length<b[i].length) length=b[i].length;
		}
		return length;
	}
}   