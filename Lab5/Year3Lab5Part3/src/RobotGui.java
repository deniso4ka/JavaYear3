import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class RobotGui extends JFrame  implements ActionListener{
	
	String[] type = { "LegoRobot","StickManRobot" };
	   JComboBox combo;
	   JPanel panelForCombo;
	   RobotDirector robotDirector;
	   
	  
	  public RobotGui(){
		  panelForCombo = new JPanel();
		   combo = new JComboBox(type);
		   panelForCombo.add(combo);
		   add(panelForCombo, BorderLayout.SOUTH);
		   combo.addActionListener(this);	 
	   }
	  
		public static void main(String[] args) {
			// TODO Auto-generated method stub
		
			RobotGui robot = new RobotGui();
			robot.setSize(500,500);   
			robot.setVisible(true);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		  Object choice = combo.getSelectedItem();
			String choicePicked = choice.toString();
			robotDirector = new RobotDirector();
			
			if (choicePicked.equals("LegoRobot")) {
				this.getContentPane().removeAll();
				panelForCombo.add(combo);
				add(combo, BorderLayout.SOUTH);
				add(robotDirector.buildRobot("lego"), BorderLayout.CENTER);
				repaint();
				revalidate();
				 
			}
			else if (choicePicked.equals("StickManRobot")) {
				this.getContentPane().removeAll();
				panelForCombo.add(combo);
				add(combo, BorderLayout.SOUTH);
				add(robotDirector.buildRobot("stick"), BorderLayout.CENTER);
				repaint();
				revalidate();
				
			}
		
	}

}
