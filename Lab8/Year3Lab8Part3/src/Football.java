
import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;

public class Football extends JLabel implements Chain
{
	private Chain nextChain = null;

	public Football()
	{
		setBorder(new TitledBorder("Football Score"));
	
	}
	public void addChain(Chain c)
	{
		nextChain = c;
	}

	public void sendToChain(String mesg)
	{
		if (mesg.equals("football.jpg"))
			display();
		else
		{
			if (nextChain != null)
				nextChain.sendToChain(mesg);
		}
    }


	public Chain getChain()
	{
		return nextChain;
    }

	private void display()
	{
	
		setIcon(new ImageIcon("football.jpg"));

		

    }
}
