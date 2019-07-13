public class Duck {
	
	int size;
	public Duck(int s) {
		System.out.println("Quack");		
		if (s == 0) {
			size = 27;
		} else {
			size = s;
		}			
		System.out.println("Size is: "+size);
	}
	public void setSize(int newSize) {
		size = newSize;
		System.out.println("Size is: "+size);
	}
}