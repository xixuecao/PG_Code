import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TextArea1 implements ActionListener{
	JTextArea text;
	public static void main(String[] aegs) {
		TextArea1 gui = new TextArea1();
		gui.go();
	}
	
	public void go() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton("Just click it!");
		button.addActionListener(this);
		text = new JTextArea(10,20);
		text.setLineWrap(true);
		
		JScrollPane scrollPane = new JScrollPane(text);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel.add(scrollPane);
		
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		
		frame.setSize(350,300);
		frame.setVisible(true);	
	}
	
	public void actionPerformed(ActionEvent ex) {
		text.append("button clicked \n");
	}
}
