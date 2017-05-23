
public class Pet {
	
	
	String name;
	int age;
		
			public Pet(){
				
				name = "some name";
				age = 4;
			
			}					      //empty constructor
		
			public Pet(String name){
				
				this.name = name;      //passing the name
			}
		
			public Pet(int age){
										//passing the age
				this.age = age;	
			}

			public Pet(String name, int age){
				
				this.name = name;		//passing the name and the age
				this.age = age;	
			}
			
			public String getName(){
				
				return name;
				}						//getters not used
			
			public int getAge(){
				
				return age;
				}		


}
