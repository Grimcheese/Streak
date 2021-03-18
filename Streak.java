public class Streak
{
	private String name;
	private String description;
	private int streakLength;
	
	
	/* Constructor methods */ 
	public Streak(String newName)
	{
		this.name = newName;
		this.streakLength = 0;
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
}