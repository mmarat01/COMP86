/* Robert Jacob
 * Simple button program
 */

import javax.swing.JFrame;
import java.awt.FlowLayout;

public class Main extends JFrame {
    public static void main (String [] args) {
	      new Main (); // as a rule, the main program instantiates main object: leave it to the constructor
    }

    public Main () {
    	  // Window setup
        setSize (300, 300);
    	  setLayout (new FlowLayout ());

    	  // Put a button in
    	  Button b1 = new Button ("Push me");
    	  add (b1);

    	  // Put another button in
    	  Button b2 = new Button ("Push me also");
    	  add (b2);

    	  // Show the window
    	  setVisible (true);
    }
}
