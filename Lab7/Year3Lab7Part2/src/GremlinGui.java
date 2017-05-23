import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;









public class GremlinGui  extends JFrame implements ActionListener{

	
		GremImage image = new GremImage();
	    Vector names;
	    GremlinFactory fact = new GremlinFactory();
	    JButton button;
	    GridLayout g;
	    JPanel buttonPannel;
	    JPanel imagePannel;
	    String newGremlinsName;
	    String name;
	 
	    public GremlinGui() {
	        super("Flyweight Images");

	        loadNames();
	        setSize(910,700);
	        buttonPannel= new JPanel();
	        imagePannel= new JPanel();
	        button = new JButton("add");
	        add(buttonPannel, BorderLayout.SOUTH);
	        add(imagePannel);
	        buttonPannel.add(button);
	      
	       g = new GridLayout(2,names.size()/2);
	       imagePannel.setLayout(g);
	      
	        button.addActionListener(this);
	        setVisible(true);
	        display();
	        //repaint();
	       
	    }

	    private void loadNames() {
	        names = new Vector();

	        fact = new GremlinFactory();
	        names.addElement("Alan");
	        names.addElement("Barry");
	        names.addElement("Charlie");
	        names.addElement("Dave");
	        names.addElement("Edward");
	        names.addElement("Fred");
	        names.addElement("George");
	        names.addElement("Gremlen8");
	        names.addElement("Gremlen9");
	        names.addElement("Gremlen10");
	        names.addElement("Gremlen11");
	        names.addElement("Gremlen12");
	        names.addElement("Gremlen13");
	        names.addElement("Gremlen14");
	        names.addElement("Gremlen15");
	        names.addElement("Gremllen16");
	        names.addElement("Gremlen17");
	        names.addElement("Gremlen18");
	        names.addElement("Gremlen19");
	        names.addElement("Gremlen20");

	       
	    }

	    public void display() {
	     
	       
	        
	       
	        
	        for (int i = 0; i< names.size(); i++) {
	            name = (String)names.elementAt(i);
	           
	                image = fact.getImage();
	            //have that folder draw itself at this spot
	          imagePannel.add(image.display(name));
	           revalidate();
	       		repaint();
	        }
	     
	    }


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
			newGremlinsName=JOptionPane.showInputDialog("Please input new Gremlins name");
			JOptionPane.showMessageDialog(null, newGremlinsName);
			imagePannel.removeAll();
			loadNames();
			names.addElement(newGremlinsName);
			display();
			
			
			revalidate();
	       	repaint();
		}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GremlinGui();
		

	}



}
