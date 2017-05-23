import java.util.Random;


public class LivingThingFactory implements EarthThingsAbstractFactory{
	

	int randomizer =0;
	int min = 1;
	int max = 2;
	
	
	@Override
	public Thing getThing() {
		
	Random rand = new Random();
	randomizer = rand.nextInt((max - min) + 1) + min;
		
		if (randomizer ==1){
			
			return new Human();
			
		}
		
		else if (randomizer ==2) {
			return new Bird();
		}
		// TODO Auto-generated method stub
		
		else {
			return null;
		}
	}

}
