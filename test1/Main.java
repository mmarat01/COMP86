/**
 * Like Layout1, but modified to catch window resizings and tweak window layout
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Main extends JFrame implements ComponentListener, ActionListener {
    // Window size limits
    private static final int LARGE = 800;
    private static final int MEDIUM = 600;
    private static final int SMALL = 400;

    // Other sizes
    private static final int SMALL_URL = 8;
    private static final int LARGE_URL = 20;

    // Panels that we will rearrange
    private JPanel urlPanel;
    private JPanel canvasPanel;
    private JPanel controlsPanel;
    private JPanel settingsPanel;

    // Elements of the pop up dialoges
    private JButton settingsButton;
    private JButton controlsButton;
    private JDialog settingsPopup;
    private JDialog controlsPopup;

    private JTextField urlField;
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
      	setSize (LARGE, LARGE);
      	setDefaultCloseOperation (EXIT_ON_CLOSE);

      	setLayout (new BorderLayout());

      	// Text field at bottom, never moves
      	urlPanel = new JPanel ();
      	urlPanel.setLayout (new FlowLayout());
      	add (urlPanel, BorderLayout.SOUTH);
      	urlField = new JTextField ("http://www.cs.tufts.edu");

      	// Drawing canvas in middle, may be tweaked
      	canvasPanel = new JPanel ();
      	add (canvasPanel, BorderLayout.CENTER);

      	// Control panel, but may be moved to/from popup
      	controlsPanel = new JPanel ();
      	controlsPanel.setLayout (new FlowLayout ());

      	// Contents of the control panel
      	String[] comboStrings = { "Forward", "Back", "Home" };
      	JComboBox<String> combo = new JComboBox<String> (comboStrings);
      	controlsPanel.add (combo);
      	JButton reloadButton = new JButton ("Reload");
      	controlsPanel.add (reloadButton);
      	JButton stopButton = new JButton ("Stop");
      	controlsPanel.add (stopButton);

      	// Settings panel, but may be moved to/from popup
      	settingsPanel = new JPanel ();
      	settingsPanel.setLayout (new GridLayout (5, 1));

      	// Contents of the settings panel
      	JLabel label = new JLabel ("Settings:");
      	settingsPanel.add (label);
      	JCheckBox graphicsCB = new JCheckBox ("Graphics", true);
      	settingsPanel.add (graphicsCB);
      	JCheckBox animationCB = new JCheckBox ("Animation", true);
      	settingsPanel.add (animationCB);
      	JCheckBox javascriptCB = new JCheckBox ("Javascript", false);
      	settingsPanel.add (javascriptCB);
      	JCheckBox cookiesCB = new JCheckBox ("Cookies", false);
      	settingsPanel.add (cookiesCB);

      	/*
      	 * Set up for pop up dialogues
      	 */
      	addComponentListener (this);

      	settingsPopup = new JDialog (this, false);
      	settingsPopup.setSize (200, 400);

      	controlsPopup = new JDialog (this, false);
      	controlsPopup.setSize (400, 200);

      	/*
      	 * Buttons in URL panel for future use
      	 */
      	settingsButton = new JButton ("Settings");
      	settingsButton.addActionListener (this);
      	urlPanel.add (settingsButton);

      	controlsButton = new JButton ("Controls");
      	controlsButton.addActionListener (this);
      	urlPanel.add (controlsButton);

      	urlPanel.add (urlField);

      	setVisible (true);
    }

    /*
     * Listener responds to resize of our whole JFrame
     * If resized, we modify or reassemble the components of our window
     */
    public void componentResized (ComponentEvent e) {
	Dimension size = getSize();

	// SMALL = Use pop up dialogues
	if (size.width < SMALL || size.height < SMALL) {
	    // Borders and backgrounds
	    borders (false);
	    backgrounds (false);

	    // Remove panels, use them in popups instead
	    moveToPopups();

	    // Activate/deactivate buttons
	    settingsButton.setVisible (true);
	    controlsButton.setVisible (true);
	    urlField.setColumns (SMALL_URL);
    	}

	// MEDIUM = Get rid of borders, use background colors instead
	else if (size.width < MEDIUM || size.height < MEDIUM) {
	    // Borders and backgrounds
	    borders (false);
	    backgrounds (true);

	    // Replace panels
	    moveToMain ();

	    // Activate/deactivate buttons
	    settingsButton.setVisible (false);
	    controlsButton.setVisible (false);
	    urlField.setColumns (LARGE_URL);
	}

	// LARGE = Full layout
	else {
	    // Borders and backgrounds
	    borders (true);
	    backgrounds (false);

	    // Replace panels
	    moveToMain ();

	    // Activate/deactivate buttons
	    settingsButton.setVisible (false);
	    controlsButton.setVisible (false);
	    urlField.setColumns (LARGE_URL);
	}

	// May need to force recompute layout
	revalidate();
	repaint();
    }

    /*
     * Common code fragments from above
     */

    private void borders (boolean which) {
	if (which) {
	    urlPanel.setBorder (new LineBorder(Color.BLUE, 2));
	    canvasPanel.setBorder (new LineBorder(Color.RED, 2));
	    controlsPanel.setBorder (new LineBorder(Color.BLUE, 2));
	    settingsPanel.setBorder (new LineBorder(Color.BLUE, 2));
	    urlPanel.setBorder (new LineBorder(Color.BLUE, 2));
	}
	else {
	    urlPanel.setBorder (null);
	    canvasPanel.setBorder (null);
	    controlsPanel.setBorder (null);
	    settingsPanel.setBorder (null);
	    urlPanel.setBorder (null);
	}
    }

    private void backgrounds (boolean which) {
	if (which) {
	    controlsPanel.setBackground (Color.lightGray);
	    settingsPanel.setBackground (Color.lightGray);
	    urlPanel.setBackground (Color.lightGray);
	}
	else {
	    controlsPanel.setBackground (null);
	    settingsPanel.setBackground (null);
	    urlPanel.setBackground (null);
	}
    }

    private void moveToMain () {
	settingsPopup.remove (settingsPanel);
	controlsPopup.remove (controlsPanel);

	add (controlsPanel, BorderLayout.NORTH);
	add (settingsPanel, BorderLayout.WEST);
    }

    private void moveToPopups () {
	remove (controlsPanel);
	remove (settingsPanel);

	settingsPopup.add (settingsPanel);
	controlsPopup.add (controlsPanel);
    }

    // The other abstract methods
    public void componentHidden(ComponentEvent e) {}
    public void componentMoved(ComponentEvent e) {}
    public void componentShown(ComponentEvent e) {}

    // From the 2 buttons
    public void actionPerformed (ActionEvent e) {
	if (e.getSource()==controlsButton) {
	    controlsPopup.setVisible (true);
	}
	else if (e.getSource()==settingsButton) {
	    settingsPopup.setVisible (true);
	}
    }
}
