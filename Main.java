import java.util.Scanner;
import javax.swing.JFrame;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

import java.io.IOException;

public class Main
{
	public static void main(String[] args)
	{
		final String USER_DATA_FILE_NAME = "userdata.dat";
		
		// Display main window
		Window firstWin = new Window("Streak");
		
		// Create userdata file object and load profile from file it describes
		File userdata = new File(USER_DATA_FILE_NAME);
		Profile[] userProfile = LoadProfiles(userdata);
		
		userProfile[0].PrintProfile();
	}
	
	public static Profile[] LoadProfiles(File userdata)
	{
		Profile[] tempProfiles;
		/*
		// Check if file exists
		if(userdata.exists())
		{
			// Load userdata into program
			 
			
		}
		else
		{
			// Create new file and prompt user to create a profile
			MakeFile(userdata);
			
			tempProfiles = new Profile[1];
			tempProfiles[0] = MakeProfile();
			
		}
		*/
		MakeFile(userdata);
		tempProfiles = new Profile[1];
		tempProfiles[0] = MakeProfile();
		
		return(tempProfiles);
	}
	
	// Create a new Profile using user input
	public static Profile MakeProfile()
	{
		Profile newProfile = new Profile("Name");
		return(newProfile);
	}
	
	public static void FileCheck(File file)
	{
		if(file.exists())
		{
			// Put code for loading file here
			System.out.println("Profile file found. Loading...");
		}
		else
		{
			// Initialise Profiles File
			System.out.println("File not found. Initialising profiles");
			
			/* Follow Code only for test purposes */
			Profile defaultProfile = new Profile("Default");
			System.out.println(defaultProfile.GetName());
			
			MakeFile(file);
		}
	}
	
	
	public static void MakeFile(File newFile)
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

