import java.io.*;
import java.net.*;

public class DailyAdviceServer {
	String[] adviceList = {"Take smaller bites", "Go for the tight jeans. No they do NOT "
			+ "make you look fat", "One word: inappropriate", "Just for today, be honest."
			+ " Tell your boss what you *really* think", "You might want to rethink that haircut."};
	
	public void go() {
		try {
			ServerSocket serverSocket = new ServerSocket(4243);//监听4243端口
			
			while (true) {
				Socket sock = serverSocket.accept();
				PrintWriter write = new PrintWriter(sock.getOutputStream());
				String advice = getAdvice();
				write.println(advice);
				write.close();
				System.out.println(advice);
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}	
	}
	
	private String getAdvice() {
		int random = (int) (Math.random()*adviceList.length);
		return adviceList[random];
	}
	
	public static void main(String[] args) {
		DailyAdviceServer server = new DailyAdviceServer();
		server.go();
	}
}


