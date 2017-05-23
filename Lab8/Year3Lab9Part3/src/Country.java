
import java.util.Vector;


public class Country {
	
	private long numBodies; //Number of bodies in the solar system
	private long numPresident; //The number of allowable Suns, e.g., Earth's solar system has only one
	private Vector<Body> country= new Vector<Body>();

	
	public Country(int numPresident) {
		this.numPresident=numPresident;
	}
	
	
	public Country() {
		this.numBodies=0;
		this.numPresident=1; //default to one Sun
	}


	public long getNumPresident() {
		// TODO Auto-generated method stub
		return numPresident;
	}
	
	public void addPresident(President president) {
		country.add(president);
	}

	

	
	
}
