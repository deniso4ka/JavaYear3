package zoo;

public class AlligatorAdapter extends Animal {

	private alligator aligatorAd;
	
	
	public AlligatorAdapter(int some) {
		// TODO Auto-generated constructor stub
		
		aligatorAd = new alligator(some);
	}

	@Override
	protected void feed() {
		// TODO Auto-generated method stub
		
		aligatorAd.feedalligator();

	}

}
