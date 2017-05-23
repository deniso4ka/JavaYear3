import java.awt.event.*;
import java.util.*;

public class HobbyComboController {

	private ComboView comboView;
	private HobbyList hobbyList;

	public HobbyComboController(ComboView comboView, HobbyList hobbyList) {
		this.comboView = comboView;
		this.hobbyList = hobbyList;
		this.comboView.addSubmitListener(new HobbyListenerList("submit"));
		this.comboView.addRefreshListener(new HobbyListenerList("refresh"));
	}

	class HobbyListenerList implements ActionListener {

		public String action;

		public HobbyListenerList(String action) {
			this.action = action;
		}

		public void actionPerformed(ActionEvent e) {
			if(this.action.equals("submit")) {
				Hobby newHobby = new Hobby(comboView.getHobbyText());
				hobbyList.addHobby(newHobby);
			}
			else {
				ArrayList<Hobby> hobbyVector = hobbyList.getHobbies();
				String [] hobbyArray = new String [hobbyVector.size()];
				for (int i =0; i < hobbyArray.length; i++) {
					hobbyArray[i] = hobbyVector.get(i).getHobbyName();
				}
				comboView.updateList(hobbyArray);
			}
		}
	}
}


