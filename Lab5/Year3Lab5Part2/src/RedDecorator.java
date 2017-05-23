
import java.awt.*;
import java.awt.event.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
/** This class decorates a CoolButton so that
the borders are invisible when the mouse
is not over the button
*/


public class RedDecorator extends Decorator {
    boolean mouse_over;    //true when mose over button
    JComponent thisComp;

    public RedDecorator(JComponent c) {
        super(c);
        mouse_over = false;
        thisComp = this;      //save this component
        //catch mouse movements in inner class
        c.addMouseListener(new MouseAdapter() {
               //set flag when mouse over
               public void mouseEntered(MouseEvent e) {
                       mouse_over = true;
                       thisComp.repaint();
               }
              //clear flag when mouse not over
              public void mouseExited(MouseEvent e) {
                       mouse_over = false;
                       thisComp.repaint();
               }
          });
    }



    //paint the button
    public void paint(Graphics g) {
        super.paint(g);      //first draw the parent button
        //if the mouse is not over the button
        //erase the borders
        if (! mouse_over) {
        	
      /* 	EmptyBorder ep = new EmptyBorder(4,4,4,4);
        	LineBorder lb = new LineBorder(Color.red,4);
        	thisComp.setBorder(new CompoundBorder(lb,ep));
        	
        	*/
        
        	 Dimension d = super.getSize();
        	g.clearRect(0, 0, d.width-1, d.height-1);
        	 Graphics2D g2 = (Graphics2D) g;
   			g2.setStroke(new BasicStroke(10));
         	 g.setColor(Color.red);
         	  g.drawRect(0, 0, d.width-1, d.height-1);
         	 
         	 
        }
    }
}
