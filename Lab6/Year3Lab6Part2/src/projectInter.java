import java.util.Enumeration;

import javax.xml.soap.Node;


public interface projectInter {


	// Leaf interface
	public String getName();
	public String getValues();


	// Node interface
	public Enumeration elements();
	public Node getChild(String nodeName);
	public void add(Object obj);
	public void remove(Object obj);

	
}
