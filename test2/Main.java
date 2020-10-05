import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Main extends JFrame {
    public static void main (String [] args) {
	java.awt.EventQueue.invokeLater (new Runnable() {
	    public void run() {
		new Main ();
            }
          });
    }

    public Main () {
	// Window setup
	setLocation (100, 100);
	setSize (500, 500);
	setDefaultCloseOperation (EXIT_ON_CLOSE);

	setLayout (new BorderLayout());

	// Text field at top
	JTextField urlField = new JTextField ("http://www.cs.tufts.edu", 30);
	urlField.setBorder (new LineBorder(Color.BLUE, 2));
	add (urlField, BorderLayout.NORTH);

	// Drawing canvas in middle
	JPanel canvas = new JPanel ();
	canvas.setBorder (new LineBorder(Color.RED, 2));
	add (canvas, BorderLayout.CENTER);

	// Control panel at bottom
	JPanel controls = new JPanel ();
	controls.setBorder (new LineBorder(Color.BLUE, 2));
	controls.setLayout (new FlowLayout ());

	// Put this inside the control panel
	String[] comboStrings = { "Forward", "Back", "Home" };
	JComboBox<String> combo = new JComboBox<String> (comboStrings);
	// For java 1.6 or before, use: "JComboBox" not "JComboBox<String>" in both places
	controls.add (combo);

	// These 2 buttons inside control panel also
	JButton reloadButton = new JButton ("Reload");
	controls.add (reloadButton);
	JButton stopButton = new JButton ("Stop");
	controls.add (stopButton);

	// Now plug the control panel into the main frame
	add (controls, BorderLayout.SOUTH);

	// Settings panel on right
	JPanel settings = new JPanel ();
	settings.setBorder (new LineBorder(Color.BLUE, 2));
	settings.setLayout (new GridLayout (5, 1));

	// Put these inside the settings panel
	JLabel label = new JLabel ("Settings:");
	settings.add (label);
	JCheckBox graphicsCB = new JCheckBox ("Graphics", true);
	settings.add (graphicsCB);
	JCheckBox animationCB = new JCheckBox ("Animation", true);
	settings.add (animationCB);
	JCheckBox javascriptCB = new JCheckBox ("Javascript", false);
	settings.add (javascriptCB);
	JCheckBox cookiesCB = new JCheckBox ("Cookies", false);
	settings.add (cookiesCB);

	// Now plug the settings panel into the main frame
	add (settings, BorderLayout.EAST);

	// And show the whole window
	setVisible (true);
    }
  }
