import java.util.regex.Pattern;


public class AccountFactory {
	
public AccountList GetAccountList(String list){
		
		
		Pattern p = Pattern.compile("C");
		boolean hasSpecialCharC = p.matcher(list).find();
		
	
		
		if (hasSpecialCharC) {
			return new CurrentAccountList(list);
		} 
		
		else{
			return new InvestmentAccountList(list);
		}
	}

}
