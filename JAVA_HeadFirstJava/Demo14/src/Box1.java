import java.io.*;

import javax.xml.ws.EndpointContext;

public class Box1 implements Serializable{
	
	private int width;
	private int heigth;
	
	public void setWidth(int w) {
		width=w;
	}
	
	public void setHeigth(int h) {
		heigth=h;
	}
	
	public static void main(String[] args) {
		Box1 myBox = new Box1();
		myBox.setWidth(50);
		myBox.setHeigth(20);
		
		try {
			FileOutputStream fs = new FileOutputStream("foo.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(myBox);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
}
