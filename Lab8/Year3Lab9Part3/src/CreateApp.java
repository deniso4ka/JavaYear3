
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class CreateApp extends JFrame{

	static Country country;
	static President presid,presid2;
	static Human human, human2;
	
	JTextArea displayArea = new JTextArea(10,50);
	JPanel displayPresident = new JPanel();
	JScrollPane displayScroll = new JScrollPane(displayArea);
	
	public CreateApp() {
		
		displayArea.setEditable(false);
		displayPresident.add(displayScroll);
		this.getContentPane().add(displayPresident);
		
		setSize(675,500);
		setVisible(true);
	}
	

	public static void main(String[] args) throws PresidentLimitException {
		
		CreateApp runApp = new CreateApp();
		
		try {
						
							country = new Country();
							
						
							presid = President.CreatePresident("Bill",country,40);
							country.addPresident(presid);
			presid2 = President.CreatePresident("Paul",country,50); //coment it out to create
			country.addPresident(presid2);						//and add one more president to get
	
			
		
 
			
							runApp.displayArea.append("President name is  " + presid.getName() + "\n\n President age is  " + presid.getAge());
			
					} catch (PresidentLimitException e) {
					
						JOptionPane.showMessageDialog(runApp, "There can be only one president","In the same country ",JOptionPane.ERROR_MESSAGE);
					}
					
				}

}

