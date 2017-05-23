import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AwardsGui extends JFrame implements ActionListener{

	private JPanel panel;
	private JPanel panelBox;
	private JPanel panelText;
	private JTextField textField;
	private JLabel label;
	private JComboBox comboPlace;
	private JComboBox comboType;
	private static String[] place = { "First", "Second", "Third" };
	private static String[] type = { "Atthletics", "HorseShow" };
	//private Medal medal;
	//private Ribbon ribbon;
	private AthleticsAwardingBody athleticBody;
	private HorseShowAwardingBody horseBody;
	

	public AwardsGui(){

		display();






	}

	public void display(){

		panelBox = new JPanel(); 
		panel = new JPanel(); 
		panelText = new JPanel();
		textField = new JTextField("some");
		add(panelBox, BorderLayout.NORTH);
		add(panel);
		add(panelText, BorderLayout.SOUTH);
		panel.setLayout(new GridBagLayout());
		comboPlace = new JComboBox(place);
		comboType = new JComboBox(type);
		panelBox.add(comboPlace);
		panelText.add(textField);
		panelBox.add(comboType);
		comboPlace.addActionListener(this);
		comboType.addActionListener(this);
		label = new JLabel();
		panel.add(label);
	
	

	}

	public static void main(String[] args) {
		AwardsGui gui = new AwardsGui();
		gui.setSize(300, 300);
		gui.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		

		Object place = comboPlace.getSelectedItem();
		String placePicked = place.toString();
		
		Object type = comboType.getSelectedItem();
		String typePicked = type.toString();
		
		athleticBody = new AthleticsAwardingBody();
		horseBody = new  HorseShowAwardingBody();
		
		if (placePicked.equals("First") && typePicked.equals("HorseShow")) {


		
			
			label.setIcon(horseBody.getPrize(1));
			textField.setText(horseBody.message());
			revalidate();
			repaint();


		}

		else if (placePicked.equals("First") && typePicked.equals("Atthletics")) {

		
			label.setIcon(athleticBody.getPrize(1));
			textField.setText(athleticBody.message());
			
			revalidate();
			repaint();

		}

		else if (placePicked.equals("Second") && typePicked.equals("HorseShow")) {


		
			label.setIcon(horseBody.getPrize(2));
			textField.setText(horseBody.message());
		
			revalidate();
			repaint();

		}


		else if (placePicked.equals("Second") && typePicked.equals("Atthletics")) {


			
			label.setIcon(athleticBody.getPrize(2));
			textField.setText(athleticBody.message());
			revalidate();
			repaint();
		
		}

		else if (placePicked.equals("Third") && typePicked.equals("HorseShow")) {


		
			label.setIcon(horseBody.getPrize(3));
			textField.setText(horseBody.message());
			revalidate();
			repaint();

		}

		else if (placePicked.equals("Third") && typePicked.equals("Atthletics")) {


			
			label.setIcon(athleticBody.getPrize(3));
			textField.setText(athleticBody.message());
			revalidate();
			repaint();


		}


	}



}
