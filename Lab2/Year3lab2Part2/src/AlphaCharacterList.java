import java.util.StringTokenizer;


public class AlphaCharacterList extends NumberList {
	
	int size;
	
	public AlphaCharacterList(String list) {
  
		StringTokenizer token = new StringTokenizer(list);

		size = token.countTokens();
		
		// Allocate some space for the array
		
		alphaList = new String[size];
		
		// Store each list item an the appropriate array
		
		for(int i = 0; i < size; i++)  {
			if (token.hasMoreTokens()){
				alphaList[i] = token.nextToken();
			}
		}
	}
	

	public void display()
	{
		System.out.print("Character List");
		for(int i = 0; i < size; i++)
			System.out.println("[" + i + "] = " + alphaList[i]);
	}


}
