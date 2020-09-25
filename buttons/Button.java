import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// public class Button extends JButton {
//     public Button (String label) {
// 	       setText (label);
//     }
// }
public class Button extends JButton implements ActionListener {
    public Button (String label) {
	     setText (label);
       addActionListener (this); //make me (button) be my listener
    }

    public void actionPerformed (ActionEvent e) {
	     System.out.println ("Button was pushed");
    }
}
