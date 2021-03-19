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
	public String getName()
	{
		return(name);
	}
	
	public String getDescription()
	{
		return(description);
	}
	
	public int getLength()
	{
		return(streakLength);
	}
	
	public void printDates()
	{
		for(int i = 0; i < date.length; i++)
		{
			System.out.println(date[i]);
		}
	}
	
	
	/* Mutator methods */
	// Appends today's date to the end of date
	public void addToday()
	{
		date[date.length - 1] = LocalDate.now();
		streakLength++;
	}
	
}