import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;




	public class TriangleCommand extends DrawCommand {
	   public TriangleCommand(JPanel p1) {
	      super(p1);
	      Dimension sz = p1.getSize();
	      x = 10;
	      y = 0;
	      dx = -40;
	      dy = 0;
	      
	      
	      
	      
	      color = Color.green;
	   }
	   public void setPanel(JPanel p1) {
	     p = p1;
	     Dimension sz = p1.getSize();
	     x = sz.width;
	   

	  }
	  }


