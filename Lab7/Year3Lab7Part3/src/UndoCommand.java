
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

public class UndoCommand extends JFrame
   implements ActionListener {

   CmdButton btCircle, btSquare,btTriangle, btUndo;
   UndoCommandClass undo_cmd;
   CircleCommand circle_command;
   SquareCommand square_command;
   TriangleCommand triangle_command;
   String buttonPressed;
 

   public UndoCommand() {
      super("Undo Commands");
      JPanel jp = new JPanel();
      getContentPane().add(jp);
      jp.setLayout(new BorderLayout());
      JPanel bp = new JPanel();
      jp.add("South", bp);
      paintPanel cp = new paintPanel();
      jp.add("Center", cp);

      btTriangle = new CmdButton("Triangle", this);
      triangle_command = new TriangleCommand(cp);
      btTriangle.setCommand (triangle_command);
      btTriangle.addActionListener (this);
      
      btCircle = new CmdButton("Circle", this);
      circle_command = new CircleCommand(cp);
      btCircle.setCommand (circle_command);
      btCircle.addActionListener (this);

      btSquare = new CmdButton("Square", this);
      square_command = new SquareCommand(cp);
      btSquare.setCommand (square_command);
      btSquare.addActionListener (this);

      btUndo = new CmdButton("Undo", this);
      undo_cmd = new UndoCommandClass();
      btUndo.setCommand (undo_cmd);
      btUndo.addActionListener (this);

      bp.add(btCircle);
      bp.add(btUndo);
      bp.add(btSquare);
      bp.add(btTriangle);
      setSize(new Dimension(400, 300));
      setVisible(true);
      square_command.setPanel(cp);
     // circle_command.setPanel(cp);
  

   }
   public void actionPerformed(ActionEvent e) {
	   String buttonName = (String) e.getActionCommand();
	   if(buttonName.equals("Square")){
		   
		   buttonPressed = "Square";
		   
	   }
	   
	   else if(buttonName.equals("Circle")){
		   
		   buttonPressed = "Circle";
		   
	   }
	   
	   else if(buttonName.equals("Triangle")){
		   
		   buttonPressed = "Triangle";
		   
	   }
	   System.out.println(buttonName);
      CommandHolder cmdh = (CommandHolder)e.getSource ();
      Command cmd = cmdh.getCommand ();
      undo_cmd.add (cmd);  //add to list
      cmd.Execute ();   //and execute
   }

   static public void main(String argv[]) {
      new UndoCommand();
   }
   //============================
   public class paintPanel extends JPanel {
      public void paint(Graphics g) {
       Dimension sz = getSize();
       g.setColor(Color.lightGray );
       g.fillRect (0, 0, sz.width , sz.height );
       circle_command.draw(g,buttonPressed);
       square_command.draw(g,buttonPressed);
       triangle_command.draw(g,buttonPressed);
    }
   }
}
