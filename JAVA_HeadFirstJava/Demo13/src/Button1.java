import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicOptionPaneUI;

public class Button1 {
	
	public static void main(String[] args) {
		Button1 gui = new Button1();
		gui.go();
	}
	
	public void go() {
		JFrame frame = new JFrame();
		JButton east = new JButton("EAST!");
		JButton north = new JButton("NORTH!");
		JButton west = new JButton("WEST!");
		JButton south = new JButton("SOUTH!");
		JButton center = new JButton("CENTER!");
		
		Font s = new Font("serif", Font.BOLD, 28);
		north.setFont(s);
		
		frame.getContentPane().add(BorderLayout.EAST, east);
		frame.getContentPane().add(BorderLayout.NORTH,north);
		frame.getContentPane().add(BorderLayout.WEST, west);
		frame.getContentPane().add(BorderLayout.SOUTH, south);
		frame.getContentPane().add(BorderLayout.CENTER, center);
		
		frame.setSize(200,200);
		frame.setVisible(true);
	}
}
