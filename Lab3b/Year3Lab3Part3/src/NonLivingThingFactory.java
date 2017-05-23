import java.util.Random;


public class NonLivingThingFactory implements EarthThingsAbstractFactory{

	int randomizer =0;
	int min = 1;
	int max = 2;
	
	
	@Override
	public Thing getThing() {
		
	Random rand = new Random();
	randomizer = rand.nextInt((max - min) + 1) + min;
		
		if (randomizer ==1){
			
			return new Car();
			
		}
		
		else if (randomizer ==2) {
			return new Stone();
		}
		// TODO Auto-generated method stub
		
		else {
			return null;
		}
	}
	
	
}
