import java.util.Scanner;
import javax.swing.JFrame;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;

import java.io.IOException;

public class Main
{
	public static void main(String[] args)
	{
		// Stores file name to be used to store use profiles
		final String USER_DATA_FILE_NAME = "userdata.dat";
		
		// Display main window
		Window win = new Window("Streak");
		
		
		
		// Load profiles from userdata file if it exists - else create a new one
		File userdata = new File(USER_DATA_FILE_NAME);
		Profile[] userProfile = SelectProfile(userdata);
		Profile activeProfile = userProfile[0];
		

		
		// 
		userProfile[0].PrintProfile();
	}
	
	
	/* 
		Begins loading Profiles from data file referred to with File object - if it exists
		All profiles stored in file are stored in an array and returned to calling method 
	*/
	public static Profile[] SelectProfile(File userdata)
	{
		Profile[] tempProfiles;
		
		
		// Check if file exists
		if(userdata.exists())
		{
			// Load userdata into program
			tempProfiles = ReadProfileFromFile(userdata);
		}
		else
		{
			// Create new file and prompt user to create a profile
			//MakeFile(userdata); // Unnecessary
			tempProfiles = new Profile[1];
			tempProfiles[0] = MakeProfile();
			WriteProfileToFile(userdata, tempProfiles);
			
		}
		

		return(tempProfiles);
	}
	
	public static Profile[] ReadProfileFromFile(File file)
	{
		ObjectInputStream inputStream = null;
		Profile[] tempProfiles = null;
		try
		{
			inputStream = new ObjectInputStream(new FileInputStream(file));
			int numberOfProfiles = inputStream.readInt();
			
			tempProfiles = new Profile[numberOfProfiles];
			for(int i = 0; i < numberOfProfiles; i++)
			{
				tempProfiles[i] = (Profile)inputStream.readObject();
			}
		}
		catch(Exception e)
		{
			System.out.println("File reading error. Closing");
			System.exit(0);
		}
		
		return(tempProfiles);
	}
	
	/* 
		WriteProfileToFile stores all the Profiles being used by streak. On every write the 
		current number of profiles is stored first and then each Profile object is written 
		starting with the active or "default" profile. 
	*/
	// Writes an array of Profiles to a file, file begins with number of stored profiles
	public static void WriteProfileToFile(File file, Profile[] tempProfile)
	{
		try
		{
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
			outputStream.writeInt(tempProfile.length);
			
			for(int i = 0; i < tempProfile.length; i++)
			{
				outputStream.writeObject(tempProfile);
				System.out.println("Profile " + tempProfile[i].ToString() + " written to file.");
			}
			
			
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

