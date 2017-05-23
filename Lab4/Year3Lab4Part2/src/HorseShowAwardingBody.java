import javax.swing.ImageIcon;


public class HorseShowAwardingBody extends AwardingBody{
	
	String congrats = "Congratulation you won";
	
	Ribbon ribbon = new Ribbon();
	
	@Override
	public ImageIcon getPrize(int position) {
		// TODO Auto-generated method stub
		
		
		
		if(position ==1){
		//	System.out.println("gold");
		return ribbon.getPrize(position);

		}
		
		else if(position ==2){
			//System.out.println("silver");
			return  ribbon.getPrize(position);
				}
		else if(position ==3){
		//	System.out.println("bronze");
			return  ribbon.getPrize(position);
				}
		else return null;
	}
	
	

public String message(){
	
	return congrats;
}

}
