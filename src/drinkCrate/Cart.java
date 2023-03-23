package drinkCrate;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Cart extends JPanel {
	/**
	 * It's a JPanel that displays information about a crate
	 */
	public class CrateCartUi extends JPanel{
		Crate crate;
		ArrayList<JLabel> sodaTypeLbls;
		
        JLabel sodaAmountLbl;
        JLabel crateCostLbl;
        JLabel totalCostLbl;
		
		public CrateCartUi(CrateEditorPanel crateEditor) {
			crateEditor.setCrateCartUi(this);
			sodaTypeLbls = new ArrayList<JLabel>();
			JPanel panel = this;
			crate = crateEditor.getCrate();
			
			// under here make panel with crate info such as crate size, bottles amount, etc
			
			//construct components
	        JLabel crateSizeLbl = new JLabel (crate.getSize()+" Crate");
	        sodaAmountLbl = new JLabel ("Soda Amount: "+crate.getSodaAmount());
	        crateCostLbl = new JLabel ("Crate Cost: "+crate.getTotalCost() + " kr");
	        totalCostLbl = new JLabel ("Total Cost: "+crate.getTotalCost()*crate.getAmount() + " kr");
	        JButton removeBtn = new JButton ("Remove");
	        JButton editBtn = new JButton ("Edit");
	        SpinnerModel amountModel = new SpinnerNumberModel(crate.getAmount(), 1, 999, 1);
	        JSpinner crateAmount = new JSpinner (amountModel);
	        JLabel endLine = new JLabel ("————————————————————————————————————————————————");
	        JLabel startLine = new JLabel ("————————————————————————————————————————————————");
	        
	        crateAmount.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					crate.setAmount(Integer.parseInt(crateAmount.getValue().toString()));
					totalCostLbl.setText("Total Cost: "+crate.getTotalCost()*crate.getAmount() + " kr");
					cartViewer.refreshLabels();
				}
			});
	        
	        removeBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					crates.remove(crate);
					Cart.this.remove(panel);
					cartViewer.refreshLabels();
					cartViewer.main.panelTabs.setSelectedIndex(0);
					cartViewer.main.panelTabs.setSelectedIndex(1);
				}
			});
	        
	        editBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new LiveCrateEditorWindow(crateEditor, CrateCartUi.this);
				}
			});
	        
	        // It's adding labels to the panel.
			for (int i = 0; i < crate.getSodaTypesAmount(); i++) {
	            JLabel sodaTypeAmount = new JLabel (crate.getSodaType(i)+" Amount: "+crate.getSodaTypeAmount(i) + " : " + crate.getSodaTypeCost(i) + " kr");
	            panel.add (sodaTypeAmount);
	            sodaTypeLbls.add(sodaTypeAmount);
	            sodaTypeAmount.setBounds (35, 85+25*i, 200, 25);
			}

	        //adjust size and set layout
	        panel.setPreferredSize (new Dimension (485, 248));
	        panel.setLayout (null);

	        //add components
	        panel.add (crateSizeLbl);
	        panel.add (sodaAmountLbl);
	        panel.add (crateCostLbl);
	        panel.add (totalCostLbl);
	        panel.add (removeBtn);
	        panel.add (editBtn);
	        panel.add (crateAmount);
	        panel.add (endLine);
	        panel.add (startLine);

	        //set component bounds (only needed by Absolute Positioning)
	        crateSizeLbl.setBounds (35, 20, 100, 25);
	        sodaAmountLbl.setBounds (35, 45, 100, 25);
	        removeBtn.setBounds (320, 190, 150, 40);
	        editBtn.setBounds (210, 190, 100, 40);
	        crateAmount.setBounds (410, 135, 60, 40);
	        endLine.setBounds (0, 240, 491, 6);
	        startLine.setBounds (0, 0, 491, 6);
	        crateCostLbl.setBounds (320, 45, 150, 25);
	        totalCostLbl.setBounds (320, 70, 150, 25);
		}
		
		/**
		 * It refreshes the labels in the GUI
		 */
		public void refresh() {
	        sodaAmountLbl.setText("Soda Amount: "+crate.getSodaAmount());
	        crateCostLbl.setText("Crate Cost: "+crate.getTotalCost() + " kr");
	        totalCostLbl.setText("Total Cost: "+crate.getTotalCost()*crate.getAmount() + " kr");
	        for (JLabel jLabel : sodaTypeLbls) {
				remove(jLabel);
			}
	        sodaTypeLbls = new ArrayList<JLabel>();
	        for (int i = 0; i < crate.getSodaTypesAmount(); i++) {
	            JLabel sodaTypeAmount = new JLabel (crate.getSodaType(i)+" Amount: "+crate.getSodaTypeAmount(i) + " : " + crate.getSodaTypeCost(i) + " kr");
	            add (sodaTypeAmount);
	            sodaTypeLbls.add(sodaTypeAmount);
	            sodaTypeAmount.setBounds (35, 85+25*i, 200, 25);
			}
		}
	}
	
	ArrayList<Crate> crates;
	int cartPanelsAmount;
	CartViewer cartViewer;

	// A constructor.
	public Cart(CartViewer cartViewer) {
		this.cartViewer = cartViewer;
		cartPanelsAmount = 0;
		crates = new ArrayList<Crate>();
	}
	
	
	/**
	 * It adds a new CrateCartUi to the JPanel, and then adjusts the size of the JPanel to fit the new
	 * CrateCartUi
	 * 
	 * @param crateEditor The CrateEditorPanel that is being added to the cart.
	 */
	public void addCrate(CrateEditorPanel crateEditor) {
		Crate crate = crateEditor.getCrate();
		crates.add(crate);
		
		cartPanelsAmount++;
		
		CrateCartUi crateUi = new CrateCartUi(crateEditor);
        
        add(crateUi);
        
      //adjust size and set layout
        setPreferredSize (new Dimension (485, 248*cartPanelsAmount+15*Math.abs(cartPanelsAmount-1)));
        setSize (new Dimension (485, 248*cartPanelsAmount+15*Math.abs(cartPanelsAmount-1)));
        GridLayout layout = new GridLayout(cartPanelsAmount, 1, 0, 15);
        setLayout (layout);
	}


	/**
	 * For each crate in the crates list, add the total cost of the crate to the amount variable.
	 * 
	 * @return The total cost of all the crates in the list.
	 */
	public int getTotalCost() {
		int amount = 0;
		for (Crate crate : crates) {
			for (int i = 0; i < crate.getAmount(); i++) {
				amount += crate.getTotalCost();
			}
		}
		return amount;
	}


	/**
	 * This function iterates through the list of crates and adds the total cost of each crate to the
	 * amount variable if the crate size is 6x6
	 * 
	 * @return The total cost of all the large crates.
	 */
	public int getLargeCost() {
		int amount = 0;
		for (Crate crate : crates) {
			if (crate.getSize().equals("6x6")) {
				for (int i = 0; i < crate.getAmount(); i++) {
					amount += crate.getTotalCost();
				}
			}
		}
		return amount;
	}


	/**
	 * This function returns the total cost of all the medium crates
	 * 
	 * @return The total cost of all the medium crates.
	 */
	public int getMediumCost() {
		int amount = 0;
		for (Crate crate : crates) {
			if (crate.getSize().equals("6x4")) {
				for (int i = 0; i < crate.getAmount(); i++) {
					amount += crate.getTotalCost();
				}
			}
		}
		return amount;
	}


	/**
	 * This function returns the total cost of all the small crates
	 * 
	 * @return The total cost of all the small crates.
	 */
	public int getSmallCost() {
		int amount = 0;
		for (Crate crate : crates) {
			if (crate.getSize().equals("4x4")) {
				for (int i = 0; i < crate.getAmount(); i++) {
					amount += crate.getTotalCost();
				}
			}
		}
		return amount;
	}


	/**
	 * > This function returns an ArrayList of Strings that contains all the soda types in the warehouse
	 * 
	 * @return An ArrayList of Strings
	 */
	public ArrayList<String> getSodaTypes() {
		ArrayList<String> types = new ArrayList<String>();
		for (Crate crate : crates) {
			for (String type : crate.getSodaTypes()) {
				if (!types.contains(type)) {
					types.add(type);
				}
			}
		}
		return types;
	}
	
	/**
	 * This function returns the amount of soda types in the vending machine
	 * 
	 * @return The size of the sodaTypes arraylist.
	 */
	public int getSodaTypesAmount() {
		return getSodaTypes().size();
	}


	/**
	 * This function returns the soda type at the given index
	 * 
	 * @param i The index of the soda type you want to get.
	 * @return The soda type at the given index.
	 */
	public String getSodaType(int i) {
		return getSodaTypes().get(i);
	}

	/**
	 * This function returns the soda types amount at the given index
	 * 
	 * @param i The index of the soda type you want to get.
	 * @return The soda types amount at the given index.
	 */
	public int getSodaTypeAmount(int i) {
		int amount = 0; 
		for (Crate crate : crates) {
			for (int j = 0; j < crate.getAmount(); j++) {
				amount += crate.getSodaTypeAmount(getSodaType(i));
			}
		}
		return amount;
	}
	
	

	/**
	 * This function returns the total cost of all the sodas of a certain type.
	 * 
	 * @param i The index of the soda type
	 * @return The cost of the soda type.
	 */
	public int getSodaTypeCost(int i) {
		int amount = 0; 
		for (Crate crate : crates) {
			for (int j = 0; j < crate.getAmount(); j++) {
				amount += crate.getSodaTypeCost(getSodaType(i));
			}
		}
		return amount;
	}

}
