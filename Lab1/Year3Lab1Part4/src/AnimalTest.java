/**
 * 
 */

/**
 * @author den
 *
 */
public class AnimalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;

		Pet pettype [] = new Pet[5];
	
		pettype[0] = new Dog("dog1",1,"meat","sit","bark","heel");
		pettype[1] = new Dog("dog2",2,"chicken","bark","sit","heel");
		pettype[2] = new Dog("dog3",3,"rabbit","heel","bark","sit");
		pettype[3] = new Cat("cat1",2,"chicken");
		pettype[4] = new Cat("cat2",3,"fish");
	
		
		
		for(i=0; i<5; i++){

			if(pettype[i].getClass().getName().equals("Dog")){
		
			
				System.out.println("-----------------------------");
				 System.out.println("the name is "+pettype[i].getName());
				 System.out.println("the age is " +pettype[i].getAge());
				 System.out.println("the food is " +pettype[i].getFood());
				 System.out.println("command 1 "+((Dog) pettype[i]).getTric1());
				 System.out.println("command 2 "+((Dog) pettype[i]).getTric2());
				 System.out.println("command 3 "+((Dog) pettype[i]).getTric3());
				 System.out.println(pettype[i].feedPet());
				 System.out.println("-----------------------------");
			
				 
			
				
			}
			
			if(pettype[i].getClass().getName().equals("Cat")){
		
			System.out.println("-----------------------------");
			 System.out.println("the name is "+pettype[i].getName());
			 System.out.println("the age is " +pettype[i].getAge());
			 System.out.println("the food is " +pettype[i].getFood());
			 System.out.println(pettype[i].feedPet());
			 System.out.println("-----------------------------");
			
			 
			}
		
		}
		
	}
		
	
		
	
		
		
		
	}


