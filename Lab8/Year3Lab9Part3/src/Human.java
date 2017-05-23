

public class Human extends Body {

	String name;
	President president;
	int age;
	
	
	public Human(String name, President president) {
		this.president = president; //set Sun that this palanet belongs to
		president.addBody(this); //add Planet to Suns orbit
		this.name = name;
	}
	

	public Human(String name, President president, int age) {
		this.president = president; //set Sun that this palanet belongs to
		president.addBody(this); //add Planet to Suns orbit
		this.age=age;
	}

	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}

