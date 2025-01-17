import java.util.*;
import java.io.*;
import java.net.*;

public class VerySimpleChatServer {
	ArrayList clientOutputStreams;
	
	public class ClientHandler implements Runnable{
		BufferedReader reader;
		Socket sock;
		public ClientHandler(Socket clientSocket){
			try {
				sock = clientSocket;
				InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(isReader);
			} catch (Exception e) {
				e.printStackTrace();// TODO: handle exception
			}
		}
		
		public void run() {
			String message;
			try {
				while ((message=reader.readLine())!=null) {
					System.out.println("read"+message);
					tellEveryone(message);
				}
			} catch (Exception e) {
				e.printStackTrace();// TODO: handle exception
			}
		}
		
	}
	
	public void tellEveryone(String message){
		Iterator it = clientOutputStreams.iterator();
		while (it.hasNext()) {
			try {
				PrintWriter writer=(PrintWriter) it.next();
				writer.println(message);
				writer.flush();
			} catch (Exception e) {
				e.printStackTrace();// TODO: handle exception
			}
		}	
	}
	
	public void go() {
		clientOutputStreams = new ArrayList();
		try {
			ServerSocket serverSocket = new ServerSocket(5000);
			while (true) {
				Socket clientSocket = serverSocket.accept();
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
				clientOutputStreams.add(writer);
				Thread t = new Thread(new ClientHandler(clientSocket));
				t.start();
				System.out.println("got a connection");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		new VerySimpleChatServer().go();
	}
}
