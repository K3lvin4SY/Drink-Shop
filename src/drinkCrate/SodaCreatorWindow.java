package drinkCrate;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class SodaCreatorWindow extends JFrame {
    private JComboBox sodaType;
    private JSlider jcomp2;
    private JLabel zeroLbl;
    private JLabel sugarLbl;
    private JLabel sugarSelectorLbl;
    private JLabel sodaTypeLbl;
    private JComboBox fantaFlavor;
    private JLabel fantaFlavorLbl;
    private JButton addBtn;
    private JButton emptyBtn;
    private JLabel sodaNameLbl;

	int iSize;
	int jSize;
	Crate crate;
	CrateEditorPanel crateEditor;
	
	// The constructor for the SodaCreatorWindow class.
    SodaCreatorWindow(int iSize, int jSize, Crate crate, CrateEditorPanel crateEditor) {
		this.iSize = iSize;
		this.jSize = jSize;
		this.crate = crate;
		this.crateEditor = crateEditor;
		
        //construct preComponents
        String[] sodaTypeItems = {"Cola", "Fanta", "Pepsi", "Sprite", "7Up", "Jarritos"};
        String[] fantaFlavorItems = {"Orange", "Tropical", "Grape"};

        //construct components
        sodaType = new JComboBox (sodaTypeItems);
        jcomp2 = new JSlider (0, 1);
        zeroLbl = new JLabel ("ZERO");
        sugarLbl = new JLabel ("Yes, please");
        sugarLbl.setToolTipText("- Maroon 5");
        sugarSelectorLbl = new JLabel ("Sugar?");
        sodaTypeLbl = new JLabel ("Soda Type");
        fantaFlavor = new JComboBox (fantaFlavorItems);
        fantaFlavorLbl = new JLabel ("Fanta Flavor");
        addBtn = new JButton ("Add");
        emptyBtn = new JButton ("Empty");
        sodaNameLbl = new JLabel (String.format("%s %s", sodaType.getSelectedItem().toString(), jcomp2.getValue() ));

        //set components properties
        jcomp2.setOrientation (JSlider.HORIZONTAL);
        jcomp2.setMinorTickSpacing (0);
        jcomp2.setMajorTickSpacing (1);
        jcomp2.setPaintTicks (true);
        jcomp2.setPaintLabels (false);

        //adjust size and set layout
        setSize (new Dimension (475, 200));
        setLayout (null);

        //add components
        add (sodaType);
        add (jcomp2);
        add (zeroLbl);
        add (sugarLbl);
        add (sugarSelectorLbl);
        add (sodaTypeLbl);
        add (fantaFlavor);
        add (fantaFlavorLbl);
        add (addBtn);
        add (emptyBtn);
        add (sodaNameLbl);

        //set component bounds (only needed by Absolute Positioning)
        sodaType.setBounds (40, 35, 175, 25);
        jcomp2.setBounds (40, 105, 175, 30);
        zeroLbl.setBounds (192, 135, 32, 15);
        sugarLbl.setBounds (16, 135, 63, 15);
        sugarSelectorLbl.setBounds (40, 80, 100, 25);
        sodaTypeLbl.setBounds (40, 10, 100, 25);
        fantaFlavor.setBounds (250, 35, 175, 25);
        fantaFlavorLbl.setBounds (250, 10, 100, 25);
        addBtn.setBounds (250, 105, 80, 30);
        emptyBtn.setBounds (345, 105, 80, 30);
        sodaNameLbl.setBounds (250, 80, 175, 25);
        
        setVisible(true);
		fantaFlavor.setVisible(false);
		fantaFlavorLbl.setVisible(false);
        
        sodaType.addActionListener(new ActionListener(){  
	    	/**
             * If the user selects Fanta, then the Fanta flavor dropdown menu and its label will be visible.
             * Otherwise, they will be hidden
             * 
             * @param e The event that occurred.
             */
            public void actionPerformed(ActionEvent e){
	    		String sodaTypeString = sodaType.getSelectedItem().toString();
	    		if (sodaTypeString.equals("Fanta")) {
					fantaFlavor.setVisible(true);
					fantaFlavorLbl.setVisible(true);
				} else {
					fantaFlavor.setVisible(false);
					fantaFlavorLbl.setVisible(false);
				}
	    	}  
	    });
        
        addBtn.addActionListener(new ActionListener(){  
	    	/**
             * This function is called when the user clicks the "Send" button. It gets the selected item from
             * the dropdown menu, and then creates a new Soda object based on the selected item
             * 
             * @param e the event that triggered the action
             */
            public void actionPerformed(ActionEvent e){
	    		String sodaTypeString = sodaType.getSelectedItem().toString();
	    		Soda soda;
	    		boolean sugar;
	    		String fantaFlavorString = fantaFlavor.getSelectedItem().toString();
	    		if (jcomp2.getValue() == 1) {
	    			sugar = false;
	    		} else {
	    			sugar = true;
	    		}
	    		if (sodaTypeString.equals(sodaTypeItems[0])) {
	    			soda = new Cola(sodaTypeString, sugar);
	    		} else if (sodaTypeString.equals(sodaTypeItems[1])) {
	    			soda = new Fanta(sodaTypeString, sugar, fantaFlavorString);
	    		} else if (sodaTypeString.equals(sodaTypeItems[2])) {
	    			soda = new Pepsi(sodaTypeString, sugar);
	    		} else if (sodaTypeString.equals(sodaTypeItems[3])) {
	    			soda = new Sprite(sodaTypeString, sugar);
	    		} else if (sodaTypeString.equals(sodaTypeItems[4])) {
	    			soda = new SevenUp(sodaTypeString, sugar);
	    		} else if (sodaTypeString.equals(sodaTypeItems[5])) {
	    			soda = new Jarritos(sodaTypeString, sugar);
	    		} else {
	    			soda = new Soda(sodaTypeString, 35, sugar);
	    		}
	    		sendSoda(soda);
	    	}
	    });
        
        emptyBtn.addActionListener(new ActionListener(){  
	    	/**
             * This function is called when the user clicks the "Send Soda" button
             * 
             * @param e The event that triggered the action.
             */
            public void actionPerformed(ActionEvent e){
	    		sendSoda(null);
	    	}
	    });
    }
	
	/**
     * This function inserts a soda into the crate and updates the GUI
     * 
     * @param soda The soda that is being sent to the crate.
     */
    private void sendSoda(Soda soda) {
		crate.insertSoda(iSize, jSize, soda);
		crateEditor.updateSodaGUI(iSize, jSize, soda);
		dispose();
	}


}
