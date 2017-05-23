
public class AccountFactoryTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String list1 = new String("C12345, C10002, C1113");
		String list2 = new String("I19876, I10002, I1113");
	
		
		AccountFactory factory1 = new AccountFactory();
		factory1.GetAccountList(list1).display();
		System.out.println("");
		
		AccountList numberList2 = factory1.GetAccountList(list2);
		numberList2.display();
		
		System.out.println("");
	
		
		
	}

}
