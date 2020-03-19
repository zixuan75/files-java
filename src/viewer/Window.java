package viewer;

//import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.FlowLayout;
//import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
//import java.io.DivideByZeroException;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.io.Writer;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class Window extends JPanel{
	private static final long serialVersionUID = 1L;
	private static JFrame frame = new JFrame("Calculator");
	private static Action add = new AddAction();
	private static Action subtract = new SubtractAction();
	private static Action multiply = new MultiplyAction();
	private static Action divide = new DivideAction();
	private static Action power = new PowerAction();
	private static Action sqrtMode = new SqrtModeAction();
	private static JTextField numberfieldOne;
	private static JTextField numberfieldTwo;
	private static JLabel outputfield;
	private static JMenu menu;
	private static JButton sqrt;
	private static double ans;
	private static JMenuBar menuBar;
	public Window() {
		menu = new JMenu("Operation");
		menuBar = new JMenuBar();
		
		menu.add(new JMenuItem(add));
		menu.add(new JMenuItem(subtract));
		menu.add(new JMenuItem(multiply));
		menu.add(new JMenuItem(divide));
		menu.add(new JMenuItem(power));
		menu.add(new JMenuItem(sqrtMode));
		
		JPanel leftPanel = new JPanel();
		numberfieldOne = new JTextField(15);
		leftPanel.add(numberfieldOne);
		add(leftPanel, BorderLayout.WEST);
		
		JPanel centerPanel = new JPanel();

		menuBar.add(menu);
		outputfield = new JLabel();
		centerPanel.add(outputfield);
		centerPanel.add(menuBar);
		sqrt = new JButton("Sqrt");
		sqrt.addActionListener(new SqrtAction());
		sqrt.setForeground(Color.DARK_GRAY);
		sqrt.setVisible(false);
		centerPanel.add(sqrt);
		add(centerPanel, BorderLayout.CENTER);
		
		JPanel rightPanel = new JPanel();
		numberfieldTwo = new JTextField(15);
		rightPanel.add(numberfieldTwo);
		add(rightPanel, BorderLayout.EAST);
	}
	public void showWindow() {
    	frame.add(new Window());
    	frame.setVisible(true);
    	frame.setSize(1200, 550);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	private static class AddAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public AddAction() {
			putValue(NAME, "Add");
			putValue(SHORT_DESCRIPTION, "Add two numbers");
		}
		public void actionPerformed(ActionEvent arg0) {
			try {
				String a = numberfieldOne.getText();
				String b = numberfieldTwo.getText();
				double var;
				if ( a.equals("Ans") ||
					a.equals("ans")) {
					var = ans + Double.parseDouble(numberfieldTwo.getText());
				} else if (b.equals("Ans") ||
						b.equals("ans")) {
					var = ans + Double.parseDouble(numberfieldOne.getText());
				} else {
					var = Double.parseDouble(numberfieldOne.getText()) + Double.parseDouble(numberfieldTwo.getText());
				}
				outputfield.setText(Double.toString(var));
				ans = var;
				System.out.println(var);
			} catch (NumberFormatException e) {
				System.err.println("Only numbers allowed!");
				e.printStackTrace();
			}
			numberfieldOne.setText("");
			numberfieldTwo.setText("");
		}
		
	}
	private static class SubtractAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public SubtractAction() {
			putValue(NAME, "Subtract");
			putValue(SHORT_DESCRIPTION, "Subtract two numbers");
		}
		public void actionPerformed(ActionEvent arg0) {
			try {
				String a = numberfieldOne.getText();
				String b = numberfieldTwo.getText();
				double var;
				if ( a.equals("Ans") ||
					a.equals("ans")) {
					var = ans - Double.parseDouble(numberfieldTwo.getText());
				} else if (b.equals("Ans") ||
						b.equals("ans")) {
					var = Double.parseDouble(numberfieldOne.getText()) - ans;
				} else {
					var = Double.parseDouble(numberfieldOne.getText()) - Double.parseDouble(numberfieldTwo.getText());
				}
				outputfield.setText(Double.toString(var));
				ans = var;
				System.out.println(var);
			} catch (NumberFormatException e) {
				System.err.println("Only numbers allowed!");
				e.printStackTrace();
			}
			numberfieldOne.setText("");
			numberfieldTwo.setText("");
		}
		
	}
	private static class MultiplyAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public MultiplyAction() {
			putValue(NAME, "Multiply");
			putValue(SHORT_DESCRIPTION, "Multiply two numbers");
		}
		public void actionPerformed(ActionEvent arg0) {
			try {
				String a = numberfieldOne.getText();
				String b = numberfieldTwo.getText();
				double var;
				if ( a.equals("Ans") ||
					a.equals("ans")) {
					var = ans * Double.parseDouble(numberfieldTwo.getText());
				} else if (b.equals("Ans") ||
						b.equals("ans")) {
					var = ans * Double.parseDouble(numberfieldOne.getText());
				} else {
					var = Double.parseDouble(numberfieldOne.getText()) * Double.parseDouble(numberfieldTwo.getText());
				}
				outputfield.setText(Double.toString(var));
				ans = var;
				System.out.println(var);
			} catch (NumberFormatException e) {
				System.err.println("Only numbers allowed!");
				e.printStackTrace();
			}
			numberfieldOne.setText("");
			numberfieldTwo.setText("");
		}
		
	}
	private static class PowerAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public PowerAction() {
			putValue(NAME, "Power");
			putValue(SHORT_DESCRIPTION, "Raise one number to the power of the other");
		}
		public void actionPerformed(ActionEvent arg0) {
			try {
				String a = numberfieldOne.getText();
				String b = numberfieldTwo.getText();
				double var;
				if ( a.equals("Ans") ||
					a.equals("ans")) {
					var = Math.pow(ans, Double.parseDouble(numberfieldTwo.getText()));
				} else if (b.equals("Ans") ||
						b.equals("ans")) {
					var = Math.pow(Double.parseDouble(numberfieldOne.getText()), ans);
				} else {
					var = Math.pow(Double.parseDouble(numberfieldOne.getText()), Double.parseDouble(numberfieldTwo.getText()));
				}
				outputfield.setText(Double.toString(var));
				ans = var;
				System.out.println(var);
			} catch (NumberFormatException e) {
				System.err.println("Only numbers allowed!");
				e.printStackTrace();
			}
			numberfieldOne.setText("");
			numberfieldTwo.setText("");
		}
		
	}
	
	private static class DivideAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public DivideAction() {
			putValue(NAME, "Divide");
			putValue(SHORT_DESCRIPTION, "Divide two numbers");
		}
		public void actionPerformed(ActionEvent arg0) {
			try {
				String a = numberfieldOne.getText();
				String b = numberfieldTwo.getText();
				double number = 0;
				if (!b.equals("ans") && !b.equals("Ans")) {
					if (Double.parseDouble(b) == 0) {
						System.err.println("Never divide by zero!");
					} else {
						if ( a.equals("Ans") ||
							a.equals("ans")) {
							number = ans / Double.parseDouble(numberfieldTwo.getText());
						} else {
							number = Double.parseDouble(numberfieldOne.getText()) / Double.parseDouble(numberfieldTwo.getText());
						}
					}
				} else {
					number = Double.parseDouble(numberfieldOne.getText()) / ans;
				}
				outputfield.setText(Double.toString(number));
				ans = number;
				System.out.println(number);
			} catch (NumberFormatException e) {
				System.err.println("Only numbers allowed!");
				e.printStackTrace();
			}
			numberfieldOne.setText("");
			numberfieldTwo.setText("");
		}
		
	}
	private static class SqrtModeAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public SqrtModeAction() {
			putValue(NAME, "Sqrt Mode");
			putValue(SHORT_DESCRIPTION, "Change into square root mode");
		}
		public void actionPerformed(ActionEvent arg0) {
			numberfieldTwo.setVisible(false);
			sqrt.setVisible(true);
			menuBar.setVisible(false);
		}
	}
	private static class SqrtAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public SqrtAction() {}
		public void actionPerformed(ActionEvent arg0) {
			try {
				String a = numberfieldOne.getText();
				double var = 0;
				if (a.equals("Ans") || 
					a.equals("ans")) {
						var = Math.sqrt(ans);
				} else {
					if (Math.signum(Double.parseDouble(numberfieldOne.getText())) == -1.0){
						System.err.println("Never square root an negative number");
					} else {
						var = Math.sqrt(Double.parseDouble(numberfieldOne.getText()));
					}
				}
				outputfield.setText(Double.toString(var));
				ans = var;
				System.out.println(var);
			} catch (NumberFormatException e) {
				System.err.println("Only numbers allowed!");
				e.printStackTrace();
			}
			numberfieldTwo.setVisible(true);
			sqrt.setVisible(false);
			menuBar.setVisible(true);
			numberfieldOne.setText("");
		}
		
	}
}
