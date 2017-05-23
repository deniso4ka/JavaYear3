
import java.util.*;

public abstract class AbstractProject {
    protected String name;
    protected float time;
    protected ProjectTask parent = null;
    protected boolean leaf = true;

    public abstract float getTime();
    public abstract String getName();
    public abstract boolean add(ProjectTask e)
        throws NoSuchElementException;
    public abstract void remove(ProjectTask e)
        throws NoSuchElementException;
    public abstract Enumeration subordinates();
    public abstract ProjectTask getChild(String s);
    public abstract float getTimes();
    public boolean isLeaf() {
        return leaf;
    }
}
