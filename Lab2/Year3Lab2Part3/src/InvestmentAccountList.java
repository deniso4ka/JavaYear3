import java.util.StringTokenizer;


public class InvestmentAccountList extends AccountList{
	
	int size;
	public InvestmentAccountList(String list) {
		// TODO Auto-generated constructor stub
  
		StringTokenizer token = new StringTokenizer(list);

		size = token.countTokens();
		
		// Allocate some space for the array
		
		charInvest = new String[size];
		
		// Store each list item an the appropriate array
		
		for(int i = 0; i < size; i++)  {
			if (token.hasMoreTokens()){
				charInvest[i] = token.nextToken();
			}
		}
	}
	

	public void display()
	{
		System.out.print("Character List");
		for(int i = 0; i < size; i++)
			System.out.println("[" + i + "] = " + charInvest[i]);
	}


}
