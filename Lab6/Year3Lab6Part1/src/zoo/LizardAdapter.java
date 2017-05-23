package zoo;


public class LizardAdapter extends Animal{
	
	private lizard lizardAd;
	
	public LizardAdapter(int some){
		
		lizardAd = new lizard(some);
	}
	

	@Override
	protected void feed() {
		// TODO Auto-generated method stub
		
		lizardAd.feedlizard();
		
	}

}