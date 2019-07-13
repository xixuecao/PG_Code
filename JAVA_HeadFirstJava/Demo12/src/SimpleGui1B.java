import javax.swing.*;
import java.awt.event.*;

public class SimpleGui1B implements ActionListener{
	JButton button;
	
	public static void main(String[] args) {	
		SimpleGui1B gui = new SimpleGui1B();
		gui.go();
	}
	
	public void go() {
		JFrame frame = new JFrame();
		button = new JButton("Click me!");//make a frame and a button
		
		button.addActionListener(this);// 向按钮注册
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(button);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {// 实现interface上的方法
		button.setText("Ï've been clicked!");
	}
}
