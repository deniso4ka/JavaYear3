
public class Dog extends Pet {

	private String tric1;
	private String tric2;
	private String tric3;
	
	public Dog(String name, int age, String tric1, String tric2, String tric3){
		
		super(name,age);
		this.tric1 = tric1;
		this.tric2 = tric2;
		this.tric3 = tric3;
	}
	

	public String getTric1(){
		
		return tric1;
		}
	
	public String getTric2(){
		
		return tric2;
		}
	
	public String getTric3(){
		
		return tric3;
		}



	

	
}
