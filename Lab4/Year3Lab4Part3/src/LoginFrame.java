import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class LoginFrame extends JFrame{

	private JPanel panel = new JPanel();
	
	private JLabel username = new JLabel("Username");
	private JLabel password = new JLabel("Password");
	private JTextField usernameField = new JTextField();
	private JTextField passwordField = new JTextField();

	
	public LoginFrame(){
		
		panel.setLayout(new GridLayout(2,2));
		add(panel);
		panel.add(username);
		panel.add(usernameField);
		panel.add(password);
		panel.add(passwordField);
		setSize(220,100);
		setTitle("Login");
	}
	
	
	
}
