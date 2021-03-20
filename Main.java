import java.util.Scanner;
import javax.swing.JFrame;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// Main class 
public class Main
{
	public static void main(String[] args)
	{
		// Display main window
		Window firstWin = display();
		
		
		Streak WriteCode = new Streak("Write Code");
		WriteCode.AddToday();
		
		WriteCode.DisplayClass();
		
		File profiles = new File("Profiles");
		FileCheck(profiles);
		
	}
	
	public static void FileCheck(File profiles)
	{
		if(profiles.exists())
		{
			// Put code for loading file here
			System.out.println("Profile file found. Loading...");
		}
		else
		{
			// Initialise Profiles File
			System.out.println("File not found. Initialising profiles");
			Profile defaultProfile = new Profile("Default");
			System.out.println(defaultProfile.GetName());
		}
	}
	
	public static Window display()
	{
		Window win = new Window("Streak");
		
		return(win);
	}
	
}

