package drinkCrate;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SodaBtnPanel extends JPanel {
	JButton btn;
	JLabel btnLbl;
	
	// A constructor for the class SodaBtnPanel. It is called when you create a new instance of the class.
	public SodaBtnPanel(String size) {
		//construct components
		btn = new JButton(size);
        btnLbl = new JLabel ("Empty");

        //adjust size and set layout
        BorderLayout layout = new BorderLayout(0, 0);
        setLayout (layout);

        //add components
        add (btn, BorderLayout.CENTER);
        add (btnLbl, BorderLayout.SOUTH);
	}
	
	/**
	 * This function returns the button
	 * 
	 * @return The button.
	 */
	public JButton getBtn() {
		return btn;
	}
	
	/**
	 * This function returns the JLabel object that is associated with the button
	 * 
	 * @return The JLabel object.
	 */
	public JLabel getLbl() {
		return btnLbl;
	}
}
