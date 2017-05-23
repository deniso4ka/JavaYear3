import javax.swing.JFrame;


public class SecureApp implements AppWelcome{

	@Override
	public JFrame getGui(String userType) {
		
		if(userType.equals("Login")){
		return new LoginFrame();
		
		}
		
		else if(userType.equals("Register")){
		return new RegisterFrame();
		}
		
		return null;
	}

}
