import java.util.Vector;



public class President extends Body {
	
	private static Vector<President> PresidentList=new Vector<President>();
	private static int numPresidents;
	private int age; //default 1 milion kilometers
	private static Country country; 
	private String name;
	private Vector<Body> bodies= new Vector<Body>();
	private static President president; //adding the static instance of sun

	
	
	
	//private constructor
	private President(String name, Country country) {
		this.name = name;
		this.country= country;
	
	}
	

	private President(String name, Country country, int age) {
		this.name = name;
		this.country = country;
		this.age = age; //Default Diameter
	}
	
									
	public static President CreatePresident(String name, Country country, int age) throws PresidentLimitException {
		  if(president==null && age>35) { //If no Sun has been created, allow Sun Singleton creation
		    president=new President(name,country,age); //Add a Sun to the Solar System
		    country = country; //set Solar system
		    return president; //Return instance of Sun
		  }
		  else{
			  
				    throw new PresidentLimitException("This Solar System can only have 1 Sun");//trow an exeption if more then one creating
				  

		  }
	}

	
	public void setAge(int age) {
		
		this.age=age;
		
	}
	
	
	public void addBody(Body body) {
		bodies.add(body);
	}
	
	
	public Vector<Body> getBodies() {
		return bodies;
	}

	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
}