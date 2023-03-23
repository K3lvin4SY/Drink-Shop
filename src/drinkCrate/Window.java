package drinkCrate;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Window extends JFrame{
	
	Cart cart;
	
	JTabbedPane panelTabs;
	
	// Creating a new window with the title "Crate Creator" and adding a tabbed pane to it.
	public Window() {
		setTitle("Crate Creator");
		CartViewer cartViewer = new CartViewer(this);
		
		CrateAdderPanel crateAdderTab = new CrateAdderPanel(cartViewer, this);
		
		PricesTable pricesTable = new PricesTable();
		
		panelTabs = new JTabbedPane();
		panelTabs.add("Crate Maker", crateAdderTab);
		panelTabs.add("Cart", cartViewer);
		panelTabs.add("Prices", pricesTable);
		
		add(panelTabs);
		setSize (new Dimension (775, 575));
		
		setVisible(true);
	}
	
	/**
	 * This function is called when the program is run.
	 */
	public static void main(String[] args) {
		new Window();
	}
}
