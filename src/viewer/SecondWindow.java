package viewer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class SecondWindow extends JPanel {
	private static final long serialVersionUID = 1L;
	private static JFrame frame = new JFrame("Usage");
	private static JTextArea textArea=new JTextArea(25, 60);
	private static JButton done;
	private static JButton readAgain;
	public SecondWindow() {
		JPanel buttonPanel = new JPanel();
		readAgain = new JButton("Read again");
		readAgain.addActionListener(new ReadAgainAction());
		readAgain.setVisible(false);
		buttonPanel.add(readAgain);
		done = new JButton("Done reading");
		done.addActionListener(new DoneAction());
		buttonPanel.add(done);
		add(buttonPanel, BorderLayout.WEST);
		JPanel panel = new JPanel();
		Font font=new Font("DejaVu Sans", 5, 12);
    	textArea.setFont(font);
    	textArea.setText("Welcome to the Calculator, There is addition, subtraction, multiplication, division, powers, and Square Root Mode (all in a menu), which we'll get into later.The first operations do what they are supposed to do. You can type Ans or ans which means the answer of the previous question (if there is any). However, you cannot do both of these together. The Sqrt Mode removes one of the inputs (because there is only one for Sqrt) and the menu. It adds a Sqrt button. You can type Ans or ans on the remaining input and it will function just like the other operations do. Once you hit the button, it does its thing and you are back in regular mode. That is all.");
    	textArea.setLineWrap(true);
    	textArea.setEditable(false);
    	panel.add(textArea);
		add(panel, BorderLayout.CENTER);
	}
	public void showWindow() {
		frame.add(new SecondWindow());
    	frame.setVisible(true);
    	frame.setSize(790, 260);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private static class DoneAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public DoneAction() {}
		public void actionPerformed(ActionEvent arg0) {
			textArea.setVisible(false);
			done.setVisible(false);
			//frame.setVisible(false);
			readAgain.setVisible(true);
		}
	}
	private static class ReadAgainAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public ReadAgainAction() {}
		public void actionPerformed(ActionEvent arg0) {

		}
	}
}
