import java.util.Scanner;
import javax.swing.JFrame;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

import java.io.IOException;

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
		
		File profiles = new File("Profiles.dat");
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
			
			MakeFile(profiles, defaultProfile);
		}
	}
	
	public static Window display()
	{
		Window win = new Window("Streak");
		
		return(win);
	}
	
	public static void MakeFile(File newFile, Profile newProfile)
	{
		ObjectOutputStream outputStream = null;
		try
		{
			outputStream = new ObjectOutputStream(new FileOutputStream(newFile));
		}
		catch(IOException e)
		{
			System.exit(0);
		}
		
		System.out.println(newFile + " created");
	}
}

