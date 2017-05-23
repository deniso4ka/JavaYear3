import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;

public class Basketball extends JLabel implements Chain
{
	private Chain nextChain;

	public Basketball()
	{
		setBorder(new TitledBorder("Basketball Score"));
		
	}
	public void addChain(Chain c)
	{
		nextChain = c;
	}

	public void sendToChain(String mesg)
	{
		if (mesg.equals("basketball.jpg"))
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
	
		setIcon(new ImageIcon("basketball.jpg"));

		

    }
}