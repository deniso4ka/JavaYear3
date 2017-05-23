import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.tree.*;


public class ProjectTree extends JFrame
implements TreeSelectionListener {
    ProjectTask prez, sap, website, payroll;
    ProjectTask analysis;
    ProjectTask coding;

    JScrollPane sp;
    JPanel treePanel;
    JTree tree;
    DefaultMutableTreeNode troot;
    JLabel cost;

    public ProjectTree() {
        super("Project tree");
        makeProjectTasks();
        setGUI();
    }
    //--------------------------------------
    private void setGUI() {
        treePanel = new JPanel();
        getContentPane().add(treePanel);
        treePanel.setLayout(new BorderLayout());

        sp = new JScrollPane();
        treePanel.add("Center", sp);
        treePanel.add("South", cost = new JLabel("          "));

        treePanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        troot = new DefaultMutableTreeNode(prez.getName());
        tree= new JTree(troot);
        tree.setBackground(Color.lightGray);
        loadTree(prez);
     

        sp.getViewport().add(tree);
        setSize(new Dimension(200, 300));
        setVisible(true);

    }
    //------------------------------------
    public void loadTree(ProjectTask topDog) {
        DefaultMutableTreeNode troot;
        troot = new DefaultMutableTreeNode(topDog.getName());
        treePanel.remove(tree);
        tree= new JTree(troot);
        tree.addTreeSelectionListener(this);
        sp.getViewport().add(tree);

        addNodes(troot, topDog);
        tree.expandRow(0);
        repaint();
    }
    //--------------------------------------

    private void addNodes(DefaultMutableTreeNode pnode, ProjectTask task) {
        DefaultMutableTreeNode node;

        Enumeration e = task.subordinates();
        if (e != null) {
            while (e.hasMoreElements()) {
                ProjectTask newProject = (ProjectTask)e.nextElement();
                node = new DefaultMutableTreeNode(newProject.getName());
                pnode.add(node);
                addNodes(node, newProject);
            }
        }
    }

    //--------------------------------------

    private void makeProjectTasks() {
        prez = new Project("Projects", 150);
        prez.add(sap = new Project("SAP", 80));
        prez.add(website = new Project("WEBSITE", 80));
        prez.add(payroll = new Project("PAYROLL", 80));
      
        
        sap.add( new ProjectTask("Requirement", 20));
        sap.add(analysis = new Project("Analysis", 20));
        analysis.add(new ProjectTask("Uml Diagram", 15));
        analysis.add(new ProjectTask("Data Analysis", 15));
        analysis.add(new ProjectTask("Screen Design ", 15));
        
        sap.add( new ProjectTask("Coding", 20));
        
        website.add(new ProjectTask("Analysis ", 20));
        website.add(new ProjectTask("Design", 20));
       website.add(coding = new Project("Coding", 20));
       coding.add( new ProjectTask("Prog Specs", 20));
       coding.add( new ProjectTask("Screens", 20));
      
       
        
        payroll.add( new ProjectTask("Design", 20));
        payroll.add( new ProjectTask("Coding", 20));
        payroll.add( new ProjectTask("Testing", 20));

        
       
      
  

       
      
       
      
       
       
       
    }
 
    
    


 
    //--------------------------------------
    public void valueChanged(TreeSelectionEvent evt) {
        TreePath path = evt.getPath();
        String selectedTerm = path.getLastPathComponent().toString();

        ProjectTask emp = prez.getChild(selectedTerm);
        if (emp != null)
            cost.setText(new Float(emp.getTimes()).toString());
    }
    //--------------------------------------
    static public void main(String argv[]) {
        new ProjectTree();
    }
}

