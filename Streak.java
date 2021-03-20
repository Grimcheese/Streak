import java.time.LocalDate;
import java.util.Scanner;

public class Streak
{
	private String name;
	private String description;
	private int streakLength;
	private LocalDate[] date;
	
	/* Constructor methods */ 
	
	/* Creates a Streak with no previous dates */
	public Streak(String newName)
	{
		name = newName;
		streakLength = 0;
		date = new LocalDate[streakLength + 1];
	}
	
	/* Creates a Streak using a previous list of dates */
	public Streak(String newName, LocalDate[] newDate)
	{
		name = newName;
		streakLength = newDate.length;
		
		date = new LocalDate[streakLength + 1];
		for(int i = 0; i < streakLength; i++)
		{
			date[i] = newDate[i];
		}
	}
	
	
	/* Accessor methods */
	public String GetName()
	{
		return(name);
	}
	
	public String GetDescription()
	{
		return(description);
	}
	
	public int GetLength()
	{
		return(streakLength);
	}
	
	public void PrintDates()
	{
		for(int i = 0; i < date.length; i++)
		{
			System.out.println(date[i]);
		}
	}
	
	public void DisplayClass()
	{
		System.out.println(name);
		System.out.println(streakLength);
		System.out.println(date.length);
		for(int i = 0; i < date.length; i++)
		{
			System.out.println(date[i]);
		}
	}
	
	
	/* Mutator methods */
	// Appends today's date to the end of date
	public void AddToday()
	{
		date[date.length - 1] = LocalDate.now();
		streakLength++;
	}
	
}