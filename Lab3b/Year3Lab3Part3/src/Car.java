
public class Car extends NonLivingThing{

	 private String uniqueAtributeName;
	 private String uniqueFuture;
	

	public Car(){

	 uniqueAtributeName = "Car";
	 uniqueFuture = "has weel";
		
		
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
		return "Car [uniqueAtributeName=" + uniqueAtributeName
				+ ", uniqueFuture=" + uniqueFuture + "]";
	}


	

	

	


	


}
