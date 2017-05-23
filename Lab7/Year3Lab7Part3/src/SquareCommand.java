import java.awt.*;
import javax.swing.*;

public class SquareCommand extends DrawCommand {
   public SquareCommand(JPanel p1) {
      super(p1);
      x = 10;
      y = 10;
      dx = 200;
      dy = 200;
      color = Color.red;
   }
   public void setPanel(JPanel p1) {
     p = p1;


  }
}

