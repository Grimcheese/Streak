import java.util.Arrays;

import java.io.Serializable;

public class Profile implements Serializable
{
	/* Class instance variables */
	
	// Name of the profile and an array of the Streaks that it contains
	private String name;
	private Streak[] streak;
	private int numberOfStreaks;
	
	/* Constructor methods */
	
	/* Creates new Profile without any streaks */
	public Profile(String newName)
	{
		name = newName;
		numberOfStreaks = 0;
	}
	
	/* Creates new Profile containing an array of Streaks */
	public Profile(String newName, Streak[] newStreaks)
	{
		name = newName;
		numberOfStreaks = newStreaks.length;
		
		streak = new Streak[numberOfStreaks];
		for(int i = 0; i < numberOfStreaks; i++)
		{
			streak[i] = newStreaks[i];
		}
	}
	
	/* Accessor methods */
	
	public String GetName()
	{
		return(name);
	}
	
	public int GetStreakNumber()
	{
		return(numberOfStreaks);
	}
	
	public Streak[] GetStreaks()
	{
		return(streak);
	}
	
	public void PrintProfile()
	{
		System.out.println("Profile name: " + name);
		System.out.println("Number of streaks: " + numberOfStreaks);
		if(numberOfStreaks > 0)
		{
			System.out.print("Streaks: " );
			for(int i = 0; i > numberOfStreaks; i++)
			{
				streak[i].DisplayClass();
			}
		}
		else
		{
			System.out.println("No Streaks");
		}
	}
	/* Mutator methods */
	
	//Appends one new Streak to the Profile
	public void AddStreak(Streak newStreak)
	{
		streak = Arrays.copyOf(streak, streak.length + 1);
		streak[streak.length - 1] = newStreak;
		numberOfStreaks++;
		
	}
	
	public void Rename(String newName)
	{
		name = newName;
	}
}