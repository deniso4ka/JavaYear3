
public class Cat extends Pet{

	public Cat(String name, int age, String food){
		
		super(name,age,food);
		
	}
	
	

	@Override
	public String feedPet() {
	
		String desc = " something for cat";
		return desc; 
	}

}
