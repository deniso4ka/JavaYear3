import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class ChainApp extends JFrame
{

	private Shooter shooter;
	private Rugby rugby;
	private Basketball bask;
	private Football foot;
	private Unknown unknown;

	public ChainApp()
	{
		super("Chain demo");

		shooter= new Shooter();
		rugby = new Rugby();
		bask = new Basketball();
		foot = new Football();
		unknown = new Unknown();

		Container c = getContentPane();

		c.setLayout(new GridLayout(1,5));
		c.add(shooter);
		c.add(rugby);
		c.add(bask);
		c.add(foot);
		c.add(unknown);

		shooter.addChain(rugby);
		rugby.addChain(bask);
		bask.addChain(foot);
		foot.addChain(unknown);
		unknown.addChain(null);


		setSize(500,500);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		ChainApp capp = new ChainApp();
	}
}