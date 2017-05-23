import java.awt.*;
import java.awt.event.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;



public class BlueDecorator extends Decorator {
    boolean mouse_over;   
    JComponent thisComp;

    public BlueDecorator(JComponent c) {
        super(c);
        mouse_over = false;
        thisComp = this;  
  
    
        c.addMouseListener(new MouseAdapter() {
              
               public void mouseEntered(MouseEvent e) {
                       mouse_over = true;
                       thisComp.repaint();
               }
            
              public void mouseExited(MouseEvent e) {
                       mouse_over = false;
                       thisComp.repaint();
               }
          });
    }

    public void paint(Graphics g) {
        super.paint(g);     
      
        if (! mouse_over) {
 
        	
        	 Dimension d = super.getSize();
        	 Graphics2D g2 = (Graphics2D) g;
        	g2.setStroke(new BasicStroke(10));
        	 g.setColor(Color.blue);
        	  g.drawRect(0, 0, d.width-1, d.height-1);
        	   g.dispose();
        	  remove(this);
               	
        }
    }
}
