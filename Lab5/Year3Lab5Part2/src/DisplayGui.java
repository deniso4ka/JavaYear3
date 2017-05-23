
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;


public class DisplayGui extends JFrame
   implements ActionListener
    
{
 
   String[] type = { "blue", "red","clear" };
   JComboBox combo = new JComboBox(type);
   
   public DisplayGui()
   {
      super ("Label");
  
     add(combo, BorderLayout.SOUTH);
      
      combo.addActionListener(this);
      setSize(500,500);
      setVisible(true);
   
   }
   public void actionPerformed(ActionEvent e)
   {
	   Object choice = combo.getSelectedItem();
		String choicePicked = choice.toString();
		
		if (choicePicked.equals("blue")) {
				this.getContentPane().removeAll();
				 add(combo, BorderLayout.SOUTH);
			 add( new BlueDecorator(new JLabel()));
			 	
			 	revalidate();
			 
		}
		else if (choicePicked.equals("red")) {
			this.getContentPane().removeAll();
			 add(combo, BorderLayout.SOUTH);
			  add( new RedDecorator(new JLabel()));
			
			 revalidate();
			
		}
		else if (choicePicked.equals("clear")) {
			this.getContentPane().removeAll();
			 add(combo, BorderLayout.SOUTH);
			  add( new NoBorderDecorator(new JLabel()));
			  revalidate();
		}
   }
   static public void main(String argv[])
   {
      new DisplayGui();
   }
}
