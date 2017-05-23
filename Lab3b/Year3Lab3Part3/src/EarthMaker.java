
import java.util.Vector;




public class EarthMaker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vector<Object> things = new Vector<Object>();
	
		
		for(int i=0; i<500000;i++){
		
		things.add(new NonLivingThingFactory().getThing());
		things.add(new LivingThingFactory().getThing());
		
		}
		
	
		
		
		

			for(int x=0; x<things.size(); x++){
			
			System.out.println(things.get(x).toString());
			
		}
			
			System.out.println("The vector size is :" +things.size());
	}	

}
