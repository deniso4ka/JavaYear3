
import java.util.*;

public class Project extends ProjectTask {
    Vector projects;

    public  Project(String initName, long initTime) {
        super(initName, initTime);
        leaf = false;
        projects = new Vector();
    }

    public Project(ProjectTask initParent, String initName, long initTime) {
        super(initParent, initName, initTime);
        leaf = false;
        projects = new Vector();
    }

    public Project(ProjectTask project) {
       
        super(project.getName (), project.getTime());
        projects = new Vector();
        leaf = false;
    }

    public boolean add(ProjectTask e) throws NoSuchElementException {
        projects.add(e);
        return true;
    }

    public void remove(ProjectTask e) throws NoSuchElementException {
        projects.removeElement(e);
    }

    public Enumeration subordinates () {
        return projects.elements ();
    }

    public ProjectTask getChild(String s) throws NoSuchElementException {

        ProjectTask newProject = null;

        if (getName().equals(s))
            return this;
        else {
            boolean found = false;
            Enumeration e = subordinates();
            while (e.hasMoreElements() && (! found)) {
                newProject = (ProjectTask)e.nextElement();
                found = newProject.getName().equals(s);
                if (! found) {
                    if (! newProject.isLeaf ()) {
                        newProject = newProject.getChild(s);
                    } else
                        newProject = null;
                    found =(newProject != null);
                }
            }
            if (found)
                return newProject;
            else
                return null;
        }
    }
    //--------------------------------------


    public float getTimes() {
        float sum = time;
        for (int i = 0; i < projects.size(); i++) {
            sum += ((ProjectTask)projects.elementAt(i)).getTimes();
        }
        return sum;
    }


}

