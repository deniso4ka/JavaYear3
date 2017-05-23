import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 * @author luke raeside
 * @version 27-02-2013
 * 
 * This is a class to represent a Sample Solar system
 * This class demonstrates the use of the Singleton Pattern through the Sun class
 * The Sun class is a Singleton and the number of Sun objects cannot exceed max of Solar System
 */

public class SampleSolarSystem extends JFrame{

	static SolarSystem alienSystem;
	static Sun yellowSun, blueSun, greenSun;
	static Planet earth,jupiter,venus,blue_earth,blue_jupiter,blue_venus,green_earth,green_jupiter,green_venus;
	
	JTextArea displayArea = new JTextArea(10,50);
	JPanel displayPanel = new JPanel();
	JScrollPane displayScroll = new JScrollPane(displayArea);
	
	public SampleSolarSystem() {
		
		displayArea.setEditable(false);
		displayPanel.add(displayScroll);
		this.getContentPane().add(displayPanel);
		
		setSize(675,500);
		setVisible(true);
	}
	
	/**
	 * Main Method Sample solar system created, edit the number of Suns beyond solar system max to see 
	 * Singleton in action
	 * 
	 */
	public static void main(String[] args) {
		
		SampleSolarSystem solarSystem = new SampleSolarSystem();
		
		try {
			//Create solar system, restricted singleton max set in parameter
			//1 means only one Sun etc.
			alienSystem = new SolarSystem(3);
			
			//Call singleton Sun public access method
			yellowSun = Sun.createSun("Yellow Sun",alienSystem);
		blueSun = Sun.createSun("Blue Sun",alienSystem);  //comment out to check only one planet
			//greenSun = Sun.createSun("Green Sun",alienSystem);  
			
			//Add Suns to the Solar System, cannot exceed maximum set by Singleton class Sun
			
			alienSystem.addSun(yellowSun);
		alienSystem.addSun(blueSun);  //comment out to check only one planet
			//alienSystem.addSun(greenSun);  
			
			earth = new Planet("Yellow Earth",yellowSun);

			blue_earth = new Planet("Blue Earth",blueSun);  //comment out to check only one planet
			
			//green_earth = new Planet("Green Earth",greenSun);  
			
			solarSystem.displayArea.append("" + alienSystem);
			
		} catch (SolarSystemSunLimitException e) {
		
			JOptionPane.showMessageDialog(solarSystem, "There can be only ONE Sun","Solar System    Error",JOptionPane.ERROR_MESSAGE);

		}
		
	}

}
