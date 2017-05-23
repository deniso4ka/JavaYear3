import java.util.Vector;


public class TestJavaIterator {

	private Vector <Animal>animal;

	public TestJavaIterator()
	{
		animal = new Vector<Animal>();

		animal.addElement(new Pig());
		animal.addElement(new Sheep());
		animal.addElement(new Pig());
		animal.addElement(new Sheep());
		animal.addElement(new Pig());
		animal.addElement(new Sheep());
		animal.addElement(new Pig());
		animal.addElement(new Sheep());
		animal.addElement(new Pig());
		animal.addElement(new Sheep());
	
	}

	public void printAllElements()
	{
		
		CheckElement print = new CheckElement(animal.elements());

			int counter=1;
			while(print.hasNext())
			{
				
				
				System.out.println("*******************"+counter +"************************");
				print.next().callAnimaDetails();
				counter++;
			
				
				
			}
	}

	public static void main(String[] args)
	{
		TestJavaIterator app = new TestJavaIterator();

		app.printAllElements();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
