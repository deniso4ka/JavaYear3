import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;


public class ListView extends JFrame {
	
	/**
	 * reference to the application ComboView
	 */
	
	private JTextField textField;
	private JList list;
	private HobbyList hobbylist;
	private DefaultListModel model;
	private JScrollPane scrollPane;
	private JPanel listPanel;
	private JPanel buttonPanel;
	private JButton submit = new JButton("submit");
	private JButton update = new JButton("update");
	
	/**
	 * creates a object passing a reference to the HobbyController to use by ListView object
	 * @param hobbyController 
	 */
	
public ListView(){
	
	setTitle("List View");
	this.setSize(500,500);
	model = new DefaultListModel();
	list = new JList(model);
	scrollPane = new JScrollPane(list);
	buttonPanel = new JPanel();
	textField = new JTextField();
	buttonPanel.add(submit);
	buttonPanel.add(update);
	
	
	getContentPane().add(scrollPane, BorderLayout.CENTER);
	getContentPane().add(buttonPanel, BorderLayout.SOUTH);
	getContentPane().add(textField, BorderLayout.NORTH);
}

void addSubmitListener(ActionListener listenForSubmitButton) {
	submit.addActionListener(listenForSubmitButton);
}

void addRefreshListener(ActionListener listenForRefreshButton) {
	update.addActionListener(listenForRefreshButton);
}

public String getHobbyField() {
	return textField.getText();
}

public void updateList(String [] items) {

	
	list.setListData(items);
	
}
	

		
		
	
}
