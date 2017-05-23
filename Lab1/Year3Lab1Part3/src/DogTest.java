import java.util.ArrayList;

/**
 * 
 */

/**
 * @author den
 *
 */
public class DogTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pet pettype [] = new Pet[3];
		pettype[0] = new Dog("dog1",1,"sit","bark","heel");
		pettype[1] = new Dog("dog2",2,"bark","sit","heel");
		pettype[2] = new Dog("dog3", 3,"heel","bark","sit");
			
			for(Pet p : pettype){
				System.out.println("-----------------------------");
				 System.out.println("the name is "+p.getName());
				 System.out.println("command 1 "+((Dog) p).getTric1());
				 System.out.println("command 2 "+((Dog) p).getTric2());
				 System.out.println("command 3 "+((Dog) p).getTric3());
				 System.out.println("the age is " +p.getAge());
				 System.out.println("-----------------------------");
				}
		
		
	}

}
