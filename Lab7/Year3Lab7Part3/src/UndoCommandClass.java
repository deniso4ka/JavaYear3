

import java.util.*;

public class UndoCommandClass implements Command {
   Vector undoList;

   public UndoCommandClass(){
      undoList = new Vector();      //list of commands to undo
   }
   //-----------------------------
   public void add(Command cmd) {
      if(! (cmd instanceof UndoCommandClass))
         undoList.add(cmd);         //add commands into list
   }
   //-----------------------------
   public void Execute() {
      int index = undoList.size () -1;

      if (index >=  0) {
         //get last command executed
         Command cmd =  (Command)undoList.elementAt (index);
         cmd.unDo ();               //undo it
         undoList.remove (index);   //and remove from list
      }
   }
   //-----------------------------
   public void unDo() {    //does nothing
   }
}
