package files;
import java.io.IOException;

import viewer.Window;
import viewer.SecondWindow;

public class MainClass {
	public static void main(String[] args) throws IOException {
		Window newWindow=new Window();
		newWindow.showWindow();
		SecondWindow secondWindow = new SecondWindow();
		secondWindow.showWindow();
	}
}
