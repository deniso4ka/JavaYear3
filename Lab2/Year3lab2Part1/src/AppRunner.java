/**
 * 
 */

/**
 * @author den
 *
 */
public class AppRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListView listView = new ListView();
		listView.setVisible(true);
		HobbyList hobbyList = new HobbyList();
		HobbyController hobbyListController = new HobbyController(listView, hobbyList);
		ComboView comboView = new ComboView();
		comboView.setVisible(true);
		HobbyComboController hobbyComboController = new HobbyComboController(comboView, hobbyList);
	}

}
