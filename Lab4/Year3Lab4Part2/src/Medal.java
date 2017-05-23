import javax.swing.ImageIcon;


public class Medal extends Prize {

	String congrats = "Congratulation You Win!!!";
	
	public Medal() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ImageIcon getPrize(int position) {
		// TODO Auto-generated method stub
		
		
		
		if(position ==1){
		//	System.out.println("gold");
		return new ImageIcon("gold.jpg");

		}
		
		else if(position ==2){
			//System.out.println("silver");
			return new ImageIcon("silver.jpg");
				}
		else if(position ==3){
		//	System.out.println("bronze");
			return new ImageIcon("bronze.jpg");
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
