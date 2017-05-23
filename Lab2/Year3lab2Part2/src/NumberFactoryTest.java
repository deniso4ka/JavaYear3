
public class NumberFactoryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String list1 = new String("1 2 3 4 5");
		String list2 = new String("1.0 1.1 1.2");
		String list3 = new String("a b c");
		
		NumberFactory factory1 = new NumberFactory();
		factory1.GetNumberList(list1).display();
		System.out.println("");
		
		NumberList numberList2 = factory1.GetNumberList(list2);
		numberList2.display();
		
		System.out.println("");
		System.out.println("Sum of list 2 : " + numberList2.sum());
		
		
		NumberList numberList3 = factory1.GetNumberList(list3);
		numberList3.display();
		
	}

	
}
