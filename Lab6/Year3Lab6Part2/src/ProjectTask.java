
import java.util.*;

public class ProjectTask extends AbstractProject {
    
	public ProjectTask(String initName, float initTime) {
        name = initName;
        time = initTime;
        leaf = true;
    }
    //--------------------------------------
    public ProjectTask(ProjectTask initParent, String initName, float initTime) {
        name = initName;
        time = initTime;
        parent = initParent;
        leaf = true;
    }
    //--------------------------------------
    public float getTime() {
        return time;
    }
    //--------------------------------------
    public String getName() {
        return name;
    }
    //--------------------------------------


    public boolean add(ProjectTask e) throws NoSuchElementException {
        throw new NoSuchElementException("No subordinates");
    }

    public void remove(ProjectTask e) throws NoSuchElementException {
        throw new NoSuchElementException("No subordinates");
    }




    public Enumeration subordinates () {
        Vector v = new Vector();
        return v.elements ();
    }



    //--------------------------------------
    public ProjectTask getChild(String s) throws NoSuchElementException {
        throw new NoSuchElementException("No children");
    }

    //--------------------------------------
    public float getTimes() {
        return time;
    }
    //--------------------------------------
    public ProjectTask getParent() {
        return parent;
    }
}
