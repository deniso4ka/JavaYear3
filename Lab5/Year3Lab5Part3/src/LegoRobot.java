import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LegoRobot extends RobotDirector implements RobotBuilder {

	
	JPanel panel;
	
	
	
	public LegoRobot(){	
	
	}
	
	
	public JPanel buildRobot(){
		 
		panel = new JPanel((new GridLayout(3,1)));
		panel.add(getTop());
		panel.add(getMiddle());
		panel.add(getBottom());
		
		return panel;
		
	}
	
		
	
		@Override
		public JLabel getTop() {
			
			return new JLabel(new ImageIcon("LegoHead.png"));	
		}
		
			@Override
			public JLabel getMiddle() {
				
				return new JLabel(new ImageIcon("LegoBody.png"));
		
		}
		
		@Override
		public JLabel getBottom() {
			
			return new JLabel(new ImageIcon("LegoLegs.png"));
		
		}

}
