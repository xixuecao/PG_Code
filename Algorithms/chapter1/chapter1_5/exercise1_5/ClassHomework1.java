package exercise1_5;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import edu.princeton.cs.algs4.StdIn;

public class ClassHomework1 {
	private FileInputStream inputStream;
	private WeightedQuickUnionUF uf;
	public ClassHomework1(int num,FileInputStream inputStream){
		this.inputStream=inputStream;
		uf=new WeightedQuickUnionUF(num);
	}
	public String time() {
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(inputStream);
		String time=null;
		while (scanner.hasNext()) {
			String line=scanner.nextLine();
			if (line!=null&&!line.trim().equals("")) {
				String[] lineArray=line.split(" ");
				if (lineArray.length==3) {
					String timelog=lineArray[0];
					int p=Integer.parseInt(lineArray[1]);
					int q=Integer.parseInt(lineArray[2]);
					if (uf.connected(p, q)) continue;
					uf.union(p, q);
					if (uf.count()==1) {
						time=timelog;
						break;
					}
				}
			}
		}
		return time;
	}
	public static void main(String[] args){
		FileInputStream inputStream;
		try{
			inputStream= new FileInputStream(StdIn.readString());
			ClassHomework1 CH1=new ClassHomework1(10,inputStream);
			System.out.println("time is: "+CH1.time());
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
/*
Log.txt

time1 0 1
time2 4 5
time3 8 9
time4 2 4
time5 5 6
time6 7 8
time7 2 5
time8 6 7
time9 1 2
time10 0 3
time11 1 9
time12 3 7
 */
