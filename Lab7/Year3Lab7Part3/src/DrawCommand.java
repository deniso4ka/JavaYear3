
import java.awt.*;
import java.util.*;
import javax.swing.*;
//parent class for redCommand and blueCommand
public class DrawCommand implements Command {
   protected Vector drawList;
   protected int x, y, dx, dy;
   protected Color color;
   protected JPanel p;

   public DrawCommand(JPanel pn) {
      drawList = new Vector();
      p = pn;     //save panel we draw on
   }
   //------------------------------------
   public void Execute() {
      drawList.add(new DrawData());
     x += dx;    //increment to next position
      y += dy;
      p.repaint();
   }
   //------------------------------------
   public void unDo() {
      int index = drawList.size() -1;
      //remove last-drawn line from list
      if(index >= 0)  {
         DrawData d = (DrawData)drawList.elementAt (index);
         drawList.remove (index);
       /* x = d.getX ();
         y = d.getY ();*/
      }
      p.repaint();
   }
   //------------------------------------
   public void draw(Graphics g, String buttonName) {
      //draw all remaining lines in list
      //called by panel's paint method
      Dimension sz = p.getSize();
      g.setColor (color);
      for (int i=0; i < drawList.size (); i++) {
    	  
     DrawData d = (DrawData)drawList.elementAt (i);

     if(buttonName.equals("Circle")){
  	  		
    	     g.drawOval(50, 50, 50, 50);
     }
    	  
     else if(buttonName.equals("Square")){
    		 
    		  g.drawRect (10, 10, 200, 200);
     }
     else if(buttonName.equals("Triangle")){
     		 
    		 g.drawPolygon(new int[] {10, 20, 30}, new int[] {100, 20, 100}, 3);
      	  }
    	
      }
     
    
   }
}
