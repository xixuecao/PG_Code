
class MyEx extends Exception {}
public class ExTestDrive {
	
	static void doRisky(String t) throws MyEx {
		System.out.print("h");
		if ("yes".equals(t)) {
			throw new MyEx();
		} 
	} 
	
	public static void main(String [] args) {
		String test = args[0];
		
		System.out.print("t");
		
		try {
			doRisky(test);			
			System.out.print("r");
			System.out.print("o");	
		}catch (MyEx e) {
			System.out.print("a");
		} finally {	
			System.out.print("w");
			System.out.println("s");
		}
	}
}

	/*
	% java ExTestDrive yes
	thaws
	% java ExTestDrive no
	throws
	*/