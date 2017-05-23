import javax.swing.JLabel;
import javax.swing.JPanel;


public class RobotDirector {
	
	public JPanel buildRobot(String robot){
		
	LegoRobot legoMan = new LegoRobot();
	StickManRobot stickMan = new StickManRobot();
		
		if(robot.equals("lego")){
			
			return legoMan.buildRobot();
		}
		
		else if(robot.equals("stick")){
		
			return stickMan.buildRobot();
		}
		
		return null;
		
	}
}

	
