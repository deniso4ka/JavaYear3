
public class Stone extends NonLivingThing{


	 private String uniqueAtributeName;
	 private String uniqueFuture;
	

	 public Stone(){

	 uniqueAtributeName = "Stone";
	 uniqueFuture = " heavy";
	
		
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
		return "Stone [uniqueAtributeName=" + uniqueAtributeName
				+ ", uniqueFuture=" + uniqueFuture + "]";
	}


	

	

	
}
