import java.util.Scanner;

import javax.swing.JFrame;

// Main class 
public class Streak
{
	public static void main(String[] args)
	{
		// Display main window
		makeWindow("Streak");
	}
	
	
	// Method to initialize main window frame
	public static void makeWindow(String winName)
	{
		JFrame mainWindow = new JFrame(winName);
		mainWindow.setSize(500,500);
		mainWindow.setVisible(true);
		mainWindow.setDefaultCloseOperation(mainWindow.EXIT_ON_CLOSE);
	}
}