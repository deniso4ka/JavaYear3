
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


public class IrelandAddress extends JPanel implements Address, ActionListener{
	
	
	private JLabel streetLabel;
	private JLabel cityLabel;
	private JLabel countyLabel;
	private JTextField streetField;
	private JTextField cityField;
	private JTextField countyField;
	private SpringLayout baseLayout;
	private Vector <String> vector = new Vector();
	private JButton button = new JButton("submit");
	private int one;
	private String street;
	private String city;
	private String county;

	public IrelandAddress(){
		
		
		display();

	

		this.setLayout(baseLayout);
		this.add(streetLabel);
		this.add(cityLabel);
		this.add(countyLabel);
		this.add(streetField);
		this.add(cityField);
		this.add(countyField);
		button.addActionListener(this);
		this.add(button);
		this.setVisible(true);
		this.setSize(250,250);
	
		
		
	
	
		
}
	
	 public void actionPerformed(ActionEvent e) {
		// AddressGui addresGui = new AddressGui();
		// IrelandAddress irelandAddress = new IrelandAddress();
			System.out.println("--------------------------------------");
			street = streetField.getText();
			city = cityField.getText();
			county = countyField.getText();
			Address(street,city);
			for(int i=0; i<vector.size(); i++){
				System.out.println(vector.get(i));
					}
				
		 
		 
 }
	


	@Override
	public void display() {
		// TODO Auto-generated method stub
		
		
		streetLabel = new JLabel("Please type the city");
		cityLabel = new JLabel("Please type the street");
		countyLabel = new JLabel("Please enter the county");
		streetField = new JTextField(10);
		cityField = new JTextField(10);
		countyField = new JTextField(10);
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.WEST, button, 88, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, button, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, countyField, 53, SpringLayout.SOUTH, cityField);
		baseLayout.putConstraint(SpringLayout.NORTH, countyLabel, 3, SpringLayout.NORTH, countyField);
		baseLayout.putConstraint(SpringLayout.WEST, countyLabel, 0, SpringLayout.WEST, streetLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, cityLabel, 3, SpringLayout.NORTH, streetField);
		baseLayout.putConstraint(SpringLayout.WEST, cityLabel, 0, SpringLayout.WEST, streetLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, cityField, 42, SpringLayout.SOUTH, streetField);
		baseLayout.putConstraint(SpringLayout.NORTH, streetLabel, 3, SpringLayout.NORTH, cityField);
		baseLayout.putConstraint(SpringLayout.WEST, streetLabel, 6, SpringLayout.EAST, cityField);
		baseLayout.putConstraint(SpringLayout.NORTH, streetField, 48, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, streetField, 0, SpringLayout.WEST, cityField);
		baseLayout.putConstraint(SpringLayout.WEST, cityField, 0, SpringLayout.WEST, countyField);
		baseLayout.putConstraint(SpringLayout.WEST, countyField, 0, SpringLayout.WEST, this);
			
	}
	

	@Override
	public Vector <String> Address(String street, String city) {
		vector.add(street);
		vector.add(city);
		vector.add(county);
		return vector;
	}
	
	public Vector<String> getVector() {
		return vector;
	}


	public void setVector(Vector<String> vector) {
		this.vector = vector;
	}
	

	
}
