import java.util.Scanner;

import javax.swing.JFrame;

// Main class 
public class Streak extends JFrame
{
	public static void main(String[] args)
	{
		// Display main window
		Streak guiWindow = new Streak;
		guiWindow.setVisible(true);
	}
	
	public Streak()
	{
		setSize(600,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}