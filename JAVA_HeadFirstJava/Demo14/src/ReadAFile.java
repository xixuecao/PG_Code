import java.io.*;

public class ReadAFile {
	public static void main(String[] args) {
		try {
			File myFile = new File("E:\\LUBO\\Java\\MyText.txt");
			FileReader fileReader = new FileReader(myFile);
			BufferedReader reader = new BufferedReader(fileReader);
			
			String line = null;
			while ((line=reader.readLine())!=null) {
				System.out.println(line);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		String toTest = "What is blue + yellow?/green";
		String[] result = toTest.split("/");
		for (String token:result) {
		System.out.println(token);
		}
	}
}
