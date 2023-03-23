package drinkCrate;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class CartViewer extends JPanel {
    private JLabel titleLbl;
    private JLabel totalCost;
    private JLabel largeCost;
    private JLabel mediumCost;
    private JLabel smallCost;
    
    public Window main;
	
	private Cart cart;
	private ArrayList<JLabel> sodaTypeAmountLbls;

	// The constructor for the CartViewer class.
    public CartViewer(Window window) {
		this.main = window;
		sodaTypeAmountLbls = new ArrayList<JLabel>();
		cart = new Cart(this);
        //construct components
        titleLbl = new JLabel ("Cart");
        totalCost = new JLabel ("Total Cost: "+cart.getTotalCost()+" kr");
        largeCost = new JLabel ("Large Crate Cost: "+cart.getLargeCost()+" kr");
        mediumCost = new JLabel ("Medium Crate Cost: "+cart.getMediumCost()+" kr");
        smallCost = new JLabel ("Small Crate Cost: "+cart.getSmallCost()+" kr");
        
        for (int i = 0; i < cart.getSodaTypesAmount(); i++) {
            JLabel sodaTypeAmount = new JLabel (cart.getSodaType(i)+" Amount: "+cart.getSodaTypeAmount(i) + " : " + cart.getSodaTypeCost(i) + " kr");
            add (sodaTypeAmount);
            sodaTypeAmountLbls.add(sodaTypeAmount);
            sodaTypeAmount.setBounds (525, 220+25*i, 215, 25);
		}
	
	    JScrollPane cartDisplayScrollPane=new JScrollPane(cart);

        //add components
        add (titleLbl);
        add (totalCost);
        add (largeCost);
        add (mediumCost);
        add (smallCost);
	    add(cartDisplayScrollPane);

        //set component bounds (only needed by Absolute Positioning)
        titleLbl.setBounds (525, 30, 100, 25);
        totalCost.setBounds (520, 385, 215, 25);
        largeCost.setBounds (525, 170, 215, 25);
        mediumCost.setBounds (525, 120, 215, 25);
        smallCost.setBounds (525, 70, 215, 25);
	    cartDisplayScrollPane.setBounds(0, 0, 505, 507);
	    //personalBookingsScrollPane.setBounds(201, 0, personalBookings.getWidth(), personalBookings.getHeight());
	    
	    
	    setLayout(null);
	
	}
	
	/**
     * This function returns the cart
     * 
     * @return The cart object.
     */
    public Cart getCart() {
		return cart;
	}
	
	/**
     * It updates the labels in the GUI
     */
    public void refreshLabels() {
        totalCost.setText("Total Cost: "+cart.getTotalCost()+" kr");
        largeCost.setText("Large Crate Cost: "+cart.getLargeCost()+" kr");
        mediumCost.setText("Medium Crate Cost: "+cart.getMediumCost()+" kr");
        smallCost.setText("Small Crate Cost: "+cart.getSmallCost()+" kr");
        
        for (JLabel jLabel : sodaTypeAmountLbls) {
			remove(jLabel);
		}
        sodaTypeAmountLbls = new ArrayList<JLabel>();
        
        System.out.println(cart.getSodaTypesAmount());
        for (int i = 0; i < cart.getSodaTypesAmount(); i++) {
            JLabel sodaTypeAmount = new JLabel (cart.getSodaType(i)+" Amount: "+cart.getSodaTypeAmount(i) + " : " + cart.getSodaTypeCost(i) + " kr");
            add (sodaTypeAmount);
            sodaTypeAmountLbls.add(sodaTypeAmount);
            sodaTypeAmount.setBounds (525, 220+25*i, 215, 25);
		}
	}
}
