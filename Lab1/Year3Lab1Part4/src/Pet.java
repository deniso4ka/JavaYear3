

public class Pet {
	
	String name;
	int age;
	String food;
	

		
			public Pet(){
				name = "some name";
				age = 4;
				food = "something";
			}					      //empty constructor
		
			public Pet(String name){
				
				this.name = name;      //passing the name
				
			}
		
			public Pet(int age){
										//passing the age
				this.age = age;	
			}

			public Pet(String name, int age, String food){
				
				this.name = name;		//passing the name and the age
				this.age = age;	
				this.food = food;
			}
			

			public String getName(){
				
				return name;
				}
											
			public int getAge(){
				
				return age;
				}

			public String getFood() {
				return food;
			}

			public void setFood(String food) {
				this.food = food;
			}

			public void setName(String name) {
				this.name = name;
			}

			public void setAge(int age) {
				this.age = age;
			}		
			
			public String feedPet(){
				
				String feed = "";
				
				return feed;
			}
			
		

}
