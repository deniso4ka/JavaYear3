import java.util.StringTokenizer;


public class CurrentAccountList extends AccountList {
	
	int size;
	public CurrentAccountList(String list) {
		// TODO Auto-generated constructor stub
  
		StringTokenizer token = new StringTokenizer(list);

		size = token.countTokens();
		
		// Allocate some space for the array
		
		charCur = new String[size];
		
		// Store each list item an the appropriate array
		
		for(int i = 0; i < size; i++)  {
			if (token.hasMoreTokens()){
				charCur[i] = token.nextToken();
			}
		}
	}
	

	public void display()
	{
		System.out.print("Character List");
		for(int i = 0; i < size; i++)
			System.out.println("[" + i + "] = " + charCur[i]);
	}

}
