/**
 * 
 */

/**
 * @author den
 *
 */
public class PetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("-------------------------------Dog-------------------------------------------");
		
		Pet dogEmpty = new Pet();
		System.out.println("The first pet empty constructor ");
		Pet dogName = new Pet("pit");
		System.out.println("The first pet name is  " +dogName.name);
		Pet dogAge = new Pet(2);
		System.out.println("The first pet age is  " +dogAge.age);
		Pet dogNameAge = new Pet("pit", 2);
		System.out.println("The first pet name is  " +dogNameAge.name+ " and  age is "+dogNameAge.age);
		
		System.out.println("-------------------------------Cat---------------------------------------------");
		
		Pet catEmpty = new Pet();
		System.out.println("The second pet empty constructor ");
		Pet catName = new Pet("tom");
		System.out.println("The second pet name is  " +catName.name);
		Pet catAge = new Pet(3);
		System.out.println("The second pet age is  " +catAge.age);
		Pet catNameAge = new Pet("tom", 3);
		System.out.println("The second pet name is  " +catNameAge.name+ " and  age is "+catNameAge.age);
		
		System.out.println("--------------------------------------------------------------------------");
		
		

	}

}
