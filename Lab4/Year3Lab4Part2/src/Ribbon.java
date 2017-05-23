import javax.swing.ImageIcon;


public class Ribbon extends Prize {
	
	String congrats = "Congratulation You Win!!!";

	public Ribbon() {
		
	}

	@Override
	public ImageIcon getPrize(int position) {
		
		if(position == 1){
		return new ImageIcon("first.jpg");
		}
		
		else if(position == 2){
			return new ImageIcon("second.jpg");
				}
		else if(position == 3){
			return new ImageIcon("third.jpg");
				}
		else return null;
	}

	public String getCongrats() {
		return congrats;
	}

	public void setCongrats(String congrats) {
		this.congrats = congrats;
	}

}