import javax.swing.*;
import javax.swing.border.*;

public class Rugby extends JLabel implements Chain
{
	private Chain nextChain;

	public Rugby()
	{
		setBorder(new TitledBorder("Rugby Score"));
	}
	
	public void addChain(Chain c)
	{
		nextChain = c;
	}
	
	public void sendToChain(String mesg)
	{
		if (mesg.equals("rugby.jpg"))
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
	
		setIcon(new ImageIcon("rugby.jpg"));

		

    }


}
