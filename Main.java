import java.util.Scanner;

import javax.swing.JFrame;

// Main class 
public class Main
{
	public static void main(String[] args)
	{
		// Display main window
		Window firstWin = display();
		
		
		Streak WriteCode = new Streak("Write Code");
		WriteCode.addToday();
		
		WriteCode.displayClass();
		
	}
	
	public static Window display()
	{
		Window win = new Window("Streak");
		
		return(win);
	}
	
}

