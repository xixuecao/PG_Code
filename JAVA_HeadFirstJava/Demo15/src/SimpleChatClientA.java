import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class SimpleChatClientA {
	JTextField outgoing;
	PrintWriter writer;
	Socket sock;
	
	public void go() {
		JFrame frame = new JFrame("Ludicrously Simple Chat Client");
		JPanel mainPanel = new JPanel();
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("send");
		sendButton.addActionListener(new sendButtonListener());		
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
		setUpNetWorking();
		frame.setSize(400,500);
		frame.setVisible(true);
	}
	
	private void setUpNetWorking() {
		try {
			sock = new Socket("127.0.0.1", 5000);
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("networking established");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public class sendButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				writer.println(outgoing.getText());// 取得文字内容
				writer.flush();// 传送到服务器
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			outgoing.setText("");
			outgoing.requestFocus();
		}	
	}
	
	public static void main(String[] args) {
		new SimpleChatClientA().go();
	}
}
