import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class AddressGui extends JFrame implements ActionListener {


	private USAddress usaAddress;
	private IrelandAddress irelandAddress;
	
	private JComboBox combo;
	private JTabbedPane test;
	private Vector<String>vector = new Vector();
	private static String[] country = { "Ireland", "USA" };
	


	public AddressGui() {

		
		test = new JTabbedPane();
		combo = new JComboBox(country);
		getContentPane().add(combo, BorderLayout.SOUTH);
		this.setSize(500, 500);
		this.setVisible(true);
		combo.addActionListener(this);
		
		
		

	}

	public void actionPerformed(ActionEvent e) {

		JComboBox comb = (JComboBox) e.getSource();
		String language = (String) comb.getSelectedItem();
		if (language.equals("Ireland")) {
			AddressFactory address = new  AddressFactory();
			address.getAddress("ir");
			test.removeAll();
			test.add(new IrelandAddress());
			getContentPane().add(test);
			revalidate();
			repaint();
			
			
			
		}

		if (language.equals("USA")) {
			AddressFactory address = new  AddressFactory();
			address.getAddress("usa");
			test.removeAll();
			test.add(new USAddress());
			getContentPane().add(test);
			revalidate();
			repaint();
	
			
		}

	
	}
	

		
		
	

	
	public static void main(String[] args) {
		AddressFactory addressFactory = new AddressFactory();
		AddressGui addressGui = new AddressGui();
	
		
		
	}

}



