import java.awt.*;

import javax.swing.*;

public class GremImage extends JPanel {
  
   
    
    public GremImage() {
       
    }
    
    
    public JPanel display(String name) {
    	
    	
    	JLabel some = new JLabel();
    	some.setIcon(new ImageIcon("gremlin.jpg"));
		
    	add(some, BorderLayout.SOUTH);
    	add(new TextField(name), BorderLayout.NORTH);
    	
		
		return this;

}
    
    
}