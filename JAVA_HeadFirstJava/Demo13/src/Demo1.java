import java.awt.Button;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Demo1 {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panelA = new JPanel();
		JPanel panelB = new JPanel();
		
		panelB.add(new Button("ButtonA"));
		panelB.add(new Button("ButtonB"));
		panelB.add(new Button("ButtonC"));
		
		panelA.add(panelB);
		
		frame.getContentPane().add(panelA);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
}
