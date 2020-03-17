package viewer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class SecondWindow extends JPanel {
	private static JFrame frame = new JFrame("Usage");
	public SecondWindow() {
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
	}
	public void showWindow() {
		frame.add(new SecondWindow());
    	frame.setVisible(true);
    	frame.setSize(1200, 550);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
