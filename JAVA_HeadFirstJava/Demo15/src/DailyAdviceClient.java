import java.io.*;
import java.net.*;

public class DailyAdviceClient {
	public void go() {
		try {
			Socket s = new Socket("127.0.0.1", 4243);//链接4243端口
			InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
			BufferedReader reader = new BufferedReader(streamReader);//创建数据串流
			
			String advice = reader.readLine();
			System.out.println(advice);
			reader.close();//关闭串流
			
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		DailyAdviceClient client = new DailyAdviceClient();
		client.go();
	}
}

