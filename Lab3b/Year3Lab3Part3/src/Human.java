
public class Human extends LivingThing{

	 private String uniqueAtributeName;
	 private String uniqueFuture;
	

	public Human(){

	 uniqueAtributeName = "Human";
	 uniqueFuture = "has head";
		
		
	 }


	public String getUniqueAtributeName() {
		return uniqueAtributeName;
	}


	public void setUniqueAtributeName(String uniqueAtributeName) {
		this.uniqueAtributeName = uniqueAtributeName;
	}


	public String getUniqueFuture() {
		return uniqueFuture;
	}


	public void setUniqueFuture(String uniqueFuture) {
		this.uniqueFuture = uniqueFuture;
	}


	@Override
	public String toString() {
		return "Human [uniqueAtributeName=" + uniqueAtributeName
				+ ", uniqueFuture=" + uniqueFuture + "]";
	}
	
	
	
}
