
class PoorDog {
	private int size;
	private String name;
	public int getsize() {
		return size;		
	}
	public String getname() {
		return name;		
	}
	public static void main(String[] args) {
		PoorDog one=new PoorDog();
		System.out.println("Dog size is:"+one.size);
		System.out.println("Dog name is:"+one.name);
	}
}
