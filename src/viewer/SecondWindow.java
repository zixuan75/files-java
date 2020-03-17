package viewer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Font;

public class SecondWindow extends JPanel {
	private static JFrame frame = new JFrame("Usage");
	private static JTextArea textArea=new JTextArea(25, 60);
	public SecondWindow() {
		JPanel panel = new JPanel();
		Font font=new Font("DejaVu Sans", 5, 12);
    	textArea.setFont(font);
    	panel.add(textArea);
		add(panel, BorderLayout.CENTER);
	}
	public void showWindow() {
		frame.add(new SecondWindow());
    	frame.setVisible(true);
    	frame.setSize(790, 260);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
