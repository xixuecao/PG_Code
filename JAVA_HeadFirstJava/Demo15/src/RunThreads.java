
public class RunThreads implements Runnable{
	public void run() {
		for (int i = 0; i < 25; i++) {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName+" is running");
		}	
	}
	
	public static void main(String[] args) {
		RunThreads runner = new RunThreads();//Make one Runnable instance.
		Thread alpha = new Thread(runner);
		Thread beta = new Thread(runner);//Make two threads, with the same Runnable
		alpha.setName("Alpha thread");
		beta.setName("Beta thread");//Name the threads.
		alpha.start();
		//beta.start();//Start the threads.
	}
}
