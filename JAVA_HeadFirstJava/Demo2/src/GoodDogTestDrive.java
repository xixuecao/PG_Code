
public class GoodDogTestDrive {
	public static void main(String[] args) {
		GoodDog one=new GoodDog();
		one.setsize(70);
		GoodDog two=new GoodDog();
		two.setsize(8);
		System.out.println("Dog one:"+one.getsize());
		System.out.println("Dog two:"+two.getsize());
		one.bark();
		two.bark();
		
	}

}
