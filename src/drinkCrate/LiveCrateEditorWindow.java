package drinkCrate;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import drinkCrate.Cart.CrateCartUi;

public class LiveCrateEditorWindow extends JFrame {
    private CrateEditorPanel crateUi;
    private JButton closeBtn;

    // Creating a new window with the crateUi and crateCartUi.
    public LiveCrateEditorWindow(CrateEditorPanel crateUi, CrateCartUi crateCartUi) {
        //construct components
        this.crateUi = crateUi;
        closeBtn = new JButton ("Close");

        //adjust size and set layout
        setSize (new Dimension (500, 600));
        setLayout (null);

        //add components
        add (this.crateUi);
        add (closeBtn);

        //set component bounds (only needed by Absolute Positioning)
        this.crateUi.setBounds (25, 25, 450, 450);
        closeBtn.setBounds (25, 500, 450, 50);
        
        closeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
        
        setVisible(true);
    }
}
