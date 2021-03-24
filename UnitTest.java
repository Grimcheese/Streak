import java.io.File;

public class UnitTest
{
	public static void main(String[] args)
	{
		MainTest();
	}
	
	public static void MainTest()
	{
		WriteProfileToFileTest();
	}
	
	public static void WriteProfileToFileTest()
	{
		Profile[] testprofile = new Profile[5];
		for(int i = 0; i < 5; i++)
		{
			String namestring = "Profile " + i;
			testprofile[i] = new Profile(namestring);
		}
		File testfile = new File("test_file.dat");
		Main.WriteProfileToFile(testfile, testprofile);
	}
	
	
}