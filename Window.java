import javax.swing.*;

public class Window extends JFrame
{
	
	public Window(String name)
	{
		setSize(600, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JButton button1 = new JButton("click");
		button1.setBounds(50,100,95,30);
		add(button1);
	}
	
	public void ShowGrid(Profile profile)
	{
		
	}

}
