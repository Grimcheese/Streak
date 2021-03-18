import java.util.Scanner;

import javax.swing.JFrame;

// Main class 
public class Main
{
	public static void main(String[] args)
	{
		// Display main window
		Window firstWin = display();
		Window seconWin = display();
		
	}
	
	public static Window display()
	{
		Window win = new Window("Streak");
		
		return(win);
	}
	
}

