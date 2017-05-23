import javax.swing.ImageIcon;


public class AthleticsAwardingBody extends AwardingBody{
	
	String congrats = "Congratulation you won";
	
	public AthleticsAwardingBody() {
		// TODO Auto-generated constructor stub
	}

	Medal medal = new Medal();
	
	@Override
	public ImageIcon getPrize(int position) {
		// TODO Auto-generated method stub
		
		
		
		if(position ==1){
		//	System.out.println("gold");
		return medal.getPrize(position);

		}
		
		else if(position ==2){
			//System.out.println("silver");
			return  medal.getPrize(position);
				}
		else if(position ==3){
		//	System.out.println("bronze");
			return  medal.getPrize(position);
				}
		else return null;
	}

public String message(){
	
	return congrats;
}



}
