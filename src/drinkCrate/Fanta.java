package drinkCrate;

public class Fanta extends Soda implements SodaTypeInterface {
	
	String flavor;

	// Calling the super class constructor and passing in the type, price, and sugar.
	public Fanta(String type, Boolean sugar, String flavor) {
		super(type, 30+getFlavorPrice(flavor), sugar);
		this.flavor = flavor;
	}
	
	/**
	 * If the flavor is "Orange", return 2. If the flavor is "Tropical", return 5. Otherwise, return 11
	 * 
	 * @param flavor The flavor of the ice cream.
	 * @return The price of the flavor.
	 */
	private static int getFlavorPrice(String flavor) {
		if (flavor.equals("Orange")) {
			return 2;
		} else if (flavor.equals("Tropical")) {
			return 5;
		} else {
			return 11;
		}
	}
	
	/**
	 * This function returns the flavor of the ice cream
	 * 
	 * @return The flavor string.
	 */
	public String getFlavorString() {
		return flavor;
	}

}
