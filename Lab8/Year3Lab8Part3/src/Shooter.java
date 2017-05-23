
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

import java.awt.*;


public class Shooter extends JPanel implements Chain,
                                   ActionListener
{
   private Chain nextChain;
   private static String[] place = { "football.jpg", "rugby.jpg", "basketball.jpg" ,"other.jpg"};
   private JButton shoot;
   private JComboBox cb;
   private JPanel cp;
   private JPanel lp;
   private JPanel bp;
   private JLabel jl;

   public Shooter()
   {
      setLayout(new GridLayout(3,1));
      cp = new JPanel();
      lp = new JPanel();
      bp = new JPanel();
      jl = new JLabel();
      cb = new JComboBox(place);
      cb.addActionListener(this);
      add(cp);
      add(lp);
      add(bp);
      cp.add(cb);
      lp.add(jl);
      shoot = new JButton("shoot ball to chain");
      bp.add(shoot);
      bp.add(shoot);
      shoot.addActionListener(this);
      setBorder(new TitledBorder("Shoot the ball to chain"));
   }

	public void actionPerformed(ActionEvent e)
	{

	Object place = cb.getSelectedItem();
	String mesg  = place.toString();
	
	jl.setIcon(new ImageIcon(mesg));
	   if(nextChain != null){
		   nextChain.sendToChain(mesg);
	}
	   
	}

	public void addChain(Chain c)
	{
	   nextChain = c;
	}

	public void sendToChain(String mesg){} //this one does nothing

	public Chain getChain()
	{
	   return nextChain;
	}

}
