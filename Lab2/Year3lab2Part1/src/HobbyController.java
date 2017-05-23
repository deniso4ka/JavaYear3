import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class HobbyController {
	
	private ListView frame; 
	private HobbyList hobbyList;
	
	public HobbyController(ListView frame, HobbyList hobbyList){
		
		this.frame = frame;
		this.hobbyList = hobbyList;
		frame.addSubmitListener(new HobbyListenerList("submit"));
		frame.addRefreshListener(new HobbyListenerList("refresh"));
		
	}
	
	class HobbyListenerList implements ActionListener{
		
		private String action;
			
	
	public HobbyListenerList(String action){
		this.action=action;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(action.equals("submit")){
			Hobby hobby = new Hobby(frame.getHobbyField());
			hobbyList.addHobby(hobby);
	
		}
		
		else{
			ArrayList<Hobby> hobbyListArray = hobbyList.getHobbies();
			String [] hobbyArray = new String [hobbyListArray.size()];
			for(int i=0; i<hobbyArray.length; i++){
				hobbyArray[i] = hobbyListArray.get(i).getHobbyName();
			}
			frame.updateList(hobbyArray);
		}
	}
	
}
}	
	

	/*public void start() {
		// TODO Auto-generated method stub
		frame = new ListView(this);
	}*/
	






