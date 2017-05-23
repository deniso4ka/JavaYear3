import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class StickManRobot extends RobotDirector implements RobotBuilder{


	
	
	
	JPanel panel;
	
	
	
	
	public StickManRobot(){
		
	
	}
	
public JPanel buildRobot(){
		

		panel = new JPanel(new GridLayout(3,1));
		panel.add(getTop());
		panel.add(getMiddle());
		panel.add(getBottom());
		
		
		return panel;	
		
	}
		
	
	@Override
			public JLabel getTop() {
			
			return new JLabel(new ImageIcon("StickmanHead.png"));
				
			}
		
			@Override
			public JLabel getMiddle() {
				
				return new JLabel(new ImageIcon("StickmanBody.png"));	
				
			}
		
			@Override
			public JLabel getBottom() {
				
				return new JLabel(new ImageIcon("StickmanLegs.png"));
				// TODO Auto-generated method stub
				
				
			}
	
	
	

}
