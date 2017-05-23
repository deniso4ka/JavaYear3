import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class ComboView extends JFrame {
	
	/**
	 * reference to the application ComboView
	 */
	
	private JTextField textField;
	private JComboBox comboBox;
	private HobbyList hobbylist;
	private JPanel buttonPanel;
	private JButton submit = new JButton("submit");
	private JButton update = new JButton("update");
	
	/**
	 * creates a object passing a reference to the HobbyController to use by ListView object
	 * @param hobbyController 
	 */
	
public ComboView(){
	
	
	setTitle("Combo Box");
	this.setSize(500,500);
	comboBox = new JComboBox();
	buttonPanel = new JPanel();
	textField = new JTextField();
	buttonPanel.add(submit);
	buttonPanel.add(update);
	
	
	getContentPane().add(comboBox, BorderLayout.CENTER);
	getContentPane().add(buttonPanel, BorderLayout.SOUTH);
	getContentPane().add(textField, BorderLayout.NORTH);
}

void addSubmitListener(ActionListener listenForSubmitButton) {
	submit.addActionListener(listenForSubmitButton);
}

void addRefreshListener(ActionListener listenForRefreshButton) {
	update.addActionListener(listenForRefreshButton);
}

public String getHobbyText() {
	return textField.getText();
}

public void updateList(String [] items) {

	for(int i=0; i<items.length;i++){
		String temp = items[i];
		comboBox.addItem(temp);
	}
	
	
}
	

		
		
	
}
