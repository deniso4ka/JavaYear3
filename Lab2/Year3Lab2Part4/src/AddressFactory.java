




public class AddressFactory {


public Address getAddress(String addressSelected){
	
	
	if(addressSelected.equals("ir")){
		
	
		return new IrelandAddress();
	}
	
	if(addressSelected.equals("usa")){
		
		return new USAddress();
	}
	
	else {
		return null;
	}
	
}





}
