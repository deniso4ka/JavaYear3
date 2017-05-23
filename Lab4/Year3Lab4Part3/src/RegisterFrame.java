import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class RegisterFrame extends JFrame{
	
	private JPanel panel = new JPanel();
	
	private JLabel name = new JLabel("name");
	private JLabel address1 = new JLabel("address1");
	private JLabel address2 = new JLabel("address2");
	private JLabel email = new JLabel("email");
	private JTextField nameField = new JTextField();
	private JTextField addressField = new JTextField();
	private JTextField addressField2 = new JTextField();
	private JTextField emailField = new JTextField();
	
	public RegisterFrame(){
		
		panel.setLayout(new GridLayout(4,2));
		add(panel);
		panel.add(name);
		panel.add(nameField);
		panel.add(address1);
		panel.add(addressField);
		panel.add(address2);
		panel.add(addressField2);
		panel.add(email);
		panel.add(emailField);
		setSize(220,200);
		setTitle("Register");
		
	}

}
