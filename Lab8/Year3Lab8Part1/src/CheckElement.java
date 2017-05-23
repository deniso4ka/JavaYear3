import java.util.Enumeration;
import java.util.NoSuchElementException;


public class CheckElement implements Iterator{
	
	
		private Enumeration animal;
		private Object element;

		public CheckElement(Enumeration animal)
		{
			this.animal = animal;
		
		}

		public Animal next()
		{
			return (Animal) animal.nextElement();
		}

		public boolean hasNext()
		{
			
			while(animal.hasMoreElements())
			{
				return true;
			
			}
			
			return false;
		}


	
	

	}





