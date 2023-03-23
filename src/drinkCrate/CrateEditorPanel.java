package drinkCrate;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JPanel;


public class CrateEditorPanel extends JPanel {
	
	HashMap<String, SodaBtnPanel> btns;
	GridLayout layout;
	Crate crate;
	Cart.CrateCartUi crateCartUi;

	// Creating a new CrateEditorPanel object.
	public CrateEditorPanel(String size) {
		crateCartUi = null;
		int sizeIValue = Integer.parseInt(size.split("x")[0]);
		int sizeJValue = Integer.parseInt(size.split("x")[1]);
		btns = new HashMap<String, SodaBtnPanel>();
		crate = new Crate(size);
		//adjust size and set layout
        layout = new GridLayout(sizeIValue, sizeJValue, 20, 20);
        setLayout (layout);
        for (int i = 1; i <= sizeIValue; i++) {
        	for (int j = 1; j <= sizeJValue; j++) {
    			SodaBtnPanel btn = new SodaBtnPanel(i+"x"+j);
    			btns.put(i+"x"+j, btn);
    			add(btn);
    			String spotState = "Empty";
    			btn.setToolTipText (String.format("%sx%s: %s", i, j, spotState));
    			final int ii = i;
    			final int jj = j;
    			btn.getBtn().addActionListener(new ActionListener(){  
    		    	public void actionPerformed(ActionEvent e){  
    		    		//spotState = "Apple";
    		    		//btn.setToolTipText (String.format("%sx%s: %s", ii, jj, "apple"));
    		    		new SodaCreatorWindow(ii, jj, crate, CrateEditorPanel.this);
    		    	}  
    		    });
			}
		}
	}

	/**
	 * It takes a string that represents the size of the crate, and then it creates a crate of that size,
	 * and then it creates a button for each spot in the crate
	 * 
	 * @param crateSizeString "4x4"
	 */
	public void update(String crateSizeString) {
		int sizeIValue = Integer.parseInt(crateSizeString.split("x")[0]);
		int sizeJValue = Integer.parseInt(crateSizeString.split("x")[1]);
		for (SodaBtnPanel btn : btns.values()) {
			btn.setVisible(false);
		}
		removeAll();
		crate = new Crate(crateSizeString);
		btns = new HashMap<String, SodaBtnPanel>();
		layout.setRows(sizeIValue);
		layout.setColumns(sizeJValue);
		for (int i = 1; i <= sizeIValue; i++) {
        	for (int j = 1; j <= sizeJValue; j++) {
        		SodaBtnPanel btn = new SodaBtnPanel(i+"x"+j);
    			btns.put(i+"x"+j, btn);
    			add(btn);
    			String spotState = "Empty";
    			btn.setToolTipText (String.format("%sx%s: %s", i, j, spotState));
    			final int ii = i;
    			final int jj = j;
    			btn.getBtn().addActionListener(new ActionListener(){  
    		    	public void actionPerformed(ActionEvent e){
    		    		//btn.setToolTipText (String.format("%sx%s: %s", ii, jj, "apple"));
    		    		new SodaCreatorWindow(ii, jj, crate, CrateEditorPanel.this);
    		    		
    		    	}  
    		    });
			}
		}
		
	}
	
	/**
	 * This function returns the crate object
	 * 
	 * @return The crate object.
	 */
	public Crate getCrate() {
		return crate;
	}

	/**
	 * This function updates the GUI with the current state of the soda in the crate
	 * 
	 * @param iSize The row of the crate
	 * @param jSize The number of rows in the crate
	 * @param soda The soda object that is being updated.
	 */
	public void updateSodaGUI(int iSize, int jSize, Soda soda) {
		SodaBtnPanel sodaBtnPanel = btns.get(iSize+"x"+jSize);
		if (soda == null) {
			sodaBtnPanel.getLbl().setText("Empty");
		} else {
			sodaBtnPanel.getLbl().setText(soda.getType()+soda.getFlavor()+" "+soda.getSugarText());
		}
		if (crateCartUi != null) {
			crateCartUi.refresh();
		}
	}
	
	/**
	 * This function sets the crateCartUi variable to the crateUi variable
	 * 
	 * @param crateUi The UI that will be used to display the cart.
	 */
	public void setCrateCartUi(Cart.CrateCartUi crateUi) {
		crateCartUi = crateUi;
	}
}
