import java.util.regex.Pattern;


public class NumberFactory {
	
	public NumberList GetNumberList(String list){
		
		
		
		
		int i = list.indexOf('.');
		//Pattern p = Pattern.compile("[a-z]");
		//boolean hasSpecialChar = p.matcher(list).find();
	
		
		if(i != -1){
			return new DoubleList(list);
		}
		
		
		else if(list.indexOf("b")!=-1) {
			return new AlphaCharacterList(list);
		} 
		
		
		else{
			return new IntList(list);
		}
	}

}
