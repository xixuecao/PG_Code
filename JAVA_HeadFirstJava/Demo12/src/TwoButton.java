import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.*;

import javax.swing.*;

public class TwoButton {
	JFrame frame;
	JLabel label;
	
	public static void main(String[] args) {
		TwoButton gui = new TwoButton();
		gui.go();
	}
	
	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton lableButton = new JButton("Change text.");
		JButton colorButton = new JButton("Change color.");
		lableButton.addActionListener(new LabelListener());
		colorButton.addActionListener(new ColorListener());
		
		label = new JLabel("I'm a label!");
		MyDrawPanel drawPanel = new MyDrawPanel();
		
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		frame.getContentPane().add(BorderLayout.WEST, label);
		frame.getContentPane().add(BorderLayout.EAST, lableButton);
		
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	
	class LabelListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			label.setText("Ouch!");
		}
	}
	
	class ColorListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			frame.repaint();
		}
	}
}
