import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** A window with one button. 
 *  Rebecca Haley, Natasha Smith, and Evangeline Chandran 
 */

public class ButtonJFrame extends JFrame implements ActionListener {
  /** My button. */
  private JButton b1;
  private JTextArea b2; 
  private JButton[][] b3;
  int numClicks = 0;

  /** Create one button in the center. */
  public ButtonJFrame() {
    
    JPanel pane1 = new JPanel(new GridLayout(3,3));
    b3 = new JButton[3][3];
    
    
    b1 = new JButton("Click me");
    b1.addActionListener(this);
    
    b2 = new JTextArea(); 

    Container c = this.getContentPane();
    c.add(this.b1, "North");
    c.add(this.b2, "South"); 

    for (int i = 0; i < b3.length; i++) {
      for (int j = 0; j < b3[i].length; j++) {
        b3[i][j] = new JButton("Click me");
        pane1.add(this.b3[i][j]);
        b3[i][j].addActionListener(this);
      }
    }
    
    c.add(pane1);
    
    this.pack();
  }
  
   /** React to a button click:  change the text on the button
    * @param e  information about the button click event that occurred
    */
  public void actionPerformed(ActionEvent e) {
    JButton b = (JButton) e.getSource(); // this points to what b1 points to!
    numClicks++;
    b1.setText("Click count: " + numClicks); // change the text of the button.

    b2.append("Click count: " + numClicks + "\n"); 
    this.pack(); 
  }
}