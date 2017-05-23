
public class Bird extends LivingThing{

	 private String uniqueAtributeName;
	 private String uniqueFuture;
	

	public Bird(){

	 uniqueAtributeName = "Bird";
	 uniqueFuture = "has wings";
		
		
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
		return "Bird [uniqueAtributeName=" + uniqueAtributeName
				+ ", uniqueFuture=" + uniqueFuture + "]";
	}

	
	
}
