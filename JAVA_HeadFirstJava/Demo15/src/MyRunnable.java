
public class MyRunnable implements Runnable{
	public void run() {
		go();
	}
	
	public void go() {	
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		domore();
	}
	
	public void domore() {
		System.out.println("top o’ the stack");
	}

}