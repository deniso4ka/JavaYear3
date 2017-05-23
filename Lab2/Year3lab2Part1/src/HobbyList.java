import java.util.ArrayList;
import java.util.Vector;


public class HobbyList{
	
	
	
	
	private ArrayList<Hobby> hobbies = new ArrayList<Hobby>();
	
	private int countHobbies=10;
	
	
	public HobbyList(){
		
	}
	
	public HobbyList(Hobby hobby){
		
		hobbies.add(hobby);
		
	}
	
	public boolean addHobby(Hobby hobby){
		
		boolean canAddHobby = false;
		
		if(countHobbies>0){
			
			hobbies.add(hobby);
			countHobbies--;
			canAddHobby = true;
		}
		
		return canAddHobby;
	}
	
	
	public ArrayList<Hobby> getHobby(){
		
		
		return hobbies;
	}

	
public ArrayList<Hobby> getHobbies() {
		
		return hobbies;
	}

	
	
	
}
