package drinkCrate;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CrateAdderPanel extends JPanel {
    private JSpinner crateAmount;
    private JLabel crateAmountLbl;
    private JLabel crateSizeLbl;
    private JComboBox crateSize;
    private CrateEditorPanel crateArea;
    private JButton addCrate;
    private JButton resetCrate;
    private String crateSizeString = "4x4";
    
    private Cart cart;
    private Window main;

    // The above code is creating a GUI for the user to add crates to the cart.
    public CrateAdderPanel(CartViewer cartViewer, Window main) {
    	
    	this.main = main;
    	this.cart = cartViewer.getCart();
    	
        //construct preComponents
        String[] crateSizeItems = {"Small", "Medium", "Large"};

        //construct components
	    SpinnerModel amountModel = new SpinnerNumberModel(1, 0, 999, 1);
	    crateAmount = new JSpinner(amountModel);
        crateAmountLbl = new JLabel ("Crate Amount:");
        crateSizeLbl = new JLabel ("Crate Size:");
        crateSize = new JComboBox (crateSizeItems);
        crateArea = new CrateEditorPanel (crateSizeString);
        addCrate = new JButton ("Add Crate");
        resetCrate = new JButton ("Reset Crate");

        //adjust size and set layout
        setPreferredSize (new Dimension (645, 425));
        setLayout (null);

        //add components
        add (crateAmount);
        add (crateAmountLbl);
        add (crateSizeLbl);
        add (crateSize);
        add (crateArea);
        add (addCrate);
        add (resetCrate);

        //set component bounds (only needed by Absolute Positioning)
        crateAmount.setBounds (30, 130, 200, 25);
        crateAmountLbl.setBounds (30, 105, 200, 25);
        crateSizeLbl.setBounds (30, 35, 200, 25);
        crateSize.setBounds (30, 60, 200, 25);
        crateArea.setBounds (260, 35, 450, 450);
        addCrate.setBounds (30, 380, 200, 45);
        resetCrate.setBounds (30, 440, 200, 45);
        
        addCrate.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){
	    		cart.addCrate(crateArea);
	    		cartViewer.refreshLabels();
	    		resetCrateGUI();
	        }  
	    });
        
        resetCrate.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){
	    		resetCrateGUI();
	        }  
	    });
        
        crateSize.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String size = crateSize.getSelectedItem().toString();
				if (size.equals("Small")) {
					crateSizeString = "4x4";
				} else if (size.equals("Medium")) {
					crateSizeString = "6x4";
				} else if (size.equals("Large")) {
					crateSizeString = "6x6";
				} else {

				}
				crateArea.update(crateSizeString);
			}
		});
        
        crateAmount.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				crateArea.getCrate().setAmount(Integer.parseInt(crateAmount.getValue().toString()));
			}
		});
    }
    
    /**
     * It removes the current crateArea, creates a new one, and then adds it back to the screen
     */
    private void resetCrateGUI() {
    	remove(crateArea);
        crateArea = new CrateEditorPanel (crateSizeString);
        crateArea.setBounds (260, 35, 450, 450);
        add(crateArea);
        crateAmount.setValue(1);
		main.panelTabs.setSelectedIndex(1); // updates the screen
		main.panelTabs.setSelectedIndex(0);
    }
}
