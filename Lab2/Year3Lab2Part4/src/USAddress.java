import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


public class USAddress extends JPanel implements Address, ActionListener{
	
	private JLabel streetLabel;
	private JLabel cityLabel;
	private JLabel zipLabel;
	private JLabel stateLabel;
	private JTextField streetField;
	private JTextField cityField;
	private JTextField zipField;
	private JTextField stateField;
	private SpringLayout baseLayout;
	private Vector <String> vector = new Vector();
	private JButton button = new JButton("submit");
	private String street;
	private String city;
	private String zip;
	private String state;

	
	public USAddress(){
		
		
	
display();
		
	


	
		this.setLayout(baseLayout);
		this.add(streetLabel);
		this.add(cityLabel);
		this.add(zipLabel);
		this.add(stateLabel);
		this.add(streetField);
		this.add(cityField);
		this.add(zipField);
		this.add(stateField);
		button.addActionListener(this);
		this.add(button);
		this.setVisible(true);
		this.setSize(250,250);
	
		
	
	

	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		streetLabel = new JLabel("Please type the city");
		cityLabel = new JLabel("Please type the street");
		zipLabel = new JLabel("Please enter the zip code");
		stateLabel = new JLabel("Please enter State");
		streetField = new JTextField(10);
		cityField = new JTextField(10);
		zipField = new JTextField(10);
		stateField = new JTextField(10);
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.WEST, button, 82, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, button, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, stateField, 34, SpringLayout.SOUTH, zipField);
		baseLayout.putConstraint(SpringLayout.NORTH, stateLabel, 3, SpringLayout.NORTH, stateField);
		baseLayout.putConstraint(SpringLayout.WEST, stateLabel, 0, SpringLayout.WEST, streetLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, zipField, 29, SpringLayout.SOUTH, cityField);
		baseLayout.putConstraint(SpringLayout.NORTH, zipLabel, 3, SpringLayout.NORTH, zipField);
		baseLayout.putConstraint(SpringLayout.WEST, zipLabel, 0, SpringLayout.WEST, streetLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, cityField, 27, SpringLayout.SOUTH, streetField);
		baseLayout.putConstraint(SpringLayout.NORTH, streetLabel, 3, SpringLayout.NORTH, cityField);
		baseLayout.putConstraint(SpringLayout.WEST, streetLabel, 0, SpringLayout.WEST, cityLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, streetField, 25, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, cityLabel, 3, SpringLayout.NORTH, streetField);
		baseLayout.putConstraint(SpringLayout.WEST, cityLabel, 6, SpringLayout.EAST, streetField);
		baseLayout.putConstraint(SpringLayout.WEST, streetField, 0, SpringLayout.WEST, cityField);
		baseLayout.putConstraint(SpringLayout.WEST, cityField, 0, SpringLayout.WEST, zipField);
		baseLayout.putConstraint(SpringLayout.WEST, stateField, 0, SpringLayout.WEST, zipField);
		baseLayout.putConstraint(SpringLayout.WEST, zipField, 0, SpringLayout.WEST, this);
	}
	
	public Vector <String> Address(String street, String city, String zip, String state) {
		vector.add(street);
		vector.add(city);
		vector.add(zip);
		vector.add(state);
		return vector;
	}
	
	public Vector<String> getVector() {
		return vector;
	}
	
	public void setVector(Vector<String> vector) {
		this.vector = vector;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("--------------------------------------");
			street = streetField.getText();
			city = cityField.getText();
			zip = zipField.getText();
			state = stateField.getText();
			Address(street,city,zip,state);
			for(int i=0; i<vector.size(); i++){
				System.out.println(vector.get(i));
					}
				
		
	}
	@Override
	public Vector<String> Address(String street, String city) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
