import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;


public class GreetingDisplay implements ActionListener{
	
	private static String[] type = { "Login", "Register" };
	private JComboBox combo = new JComboBox(type);
	private JFrame frame = new JFrame();
	
	
	private GreetingDisplay(){
		
		combo.addActionListener(this);
		frame.getContentPane();
		frame.add(combo);
		frame.setVisible(true);
		frame.setSize(40, 400);
		frame.setTitle("Welcome");
	}
	
	
	
	public static void main(String[] args) {
		GreetingDisplay run = new GreetingDisplay();
		
	
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		Object choice = combo.getSelectedItem();
		String choicePicked = choice.toString();
		SecureApp displayForm = new SecureApp();
		if (choicePicked.equals("Login")) {
	
	
		displayForm.getGui(choicePicked).getContentPane();
		displayForm.getGui(choicePicked).setVisible(true);
		displayForm.getGui(choicePicked).setSize(300,300);
			
		}

		else if (choicePicked.equals("Register")) {
			
		displayForm.getGui(choicePicked).setVisible(true);
		displayForm.getGui(choicePicked).getContentPane();
		displayForm.getGui(choicePicked).setResizable(false);

		}
		
	}

}
