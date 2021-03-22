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
	
	
	/* 
		Begins loading Profiles from data file referred to with File object - if it exists
		All profiles stored in file are stored in an array and returned to calling method 
	*/
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
			MakeFile(userdata); // Unnecessary
			
			outputStream = new ObjectOutputStream
			
			tempProfiles = new Profile[1];
			tempProfiles[0] = MakeProfile();
			WriteProfileToFile(userdata, tempProfiles);
			
		}
		*/

		tempProfiles = new Profile[1];
		tempProfiles[0] = MakeProfile();
		
		WriteProfileToFile(userdata, tempProfiles[0]);
		
		return(tempProfiles);
	}
	
	public static void WriteProfileToFile(File file, Profile tempProfile)
	{
		try
		{
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
			outputStream.writeInt(1);
			
			outputStream.writeObject(tempProfile);
			System.out.println("Profile " + tempProfile.ToString() + " written to file.");
			
		}
		catch(Exception e)
		{
			System.out.println("Error writing to file");
		}
		
	}
	
	// Create a new Profile using user input
	public static Profile MakeProfile()
	{
		Profile newProfile = new Profile("Test Profile");
		return(newProfile);
	}
	
	// Do not use
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
			
			/* Following code only for test purposes */
			Profile defaultProfile = new Profile("Default");
			System.out.println(defaultProfile.GetName());
			
			MakeFile(file);
		}
	}
	
	// Creates a new file in program directory using name from File object newFile
	public static void MakeFile(File newFile)
	{
		ObjectOutputStream outputStream = null;
		try
		{
			outputStream = new ObjectOutputStream(new FileOutputStream(newFile));
		}
		catch(IOException e)
		{
			System.out.println("Unable to create file. Closing.");
			System.exit(0);
		}
		
		System.out.println(newFile + " created");
	}
}

