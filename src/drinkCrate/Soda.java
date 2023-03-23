package drinkCrate;

public class Soda {
	int price;
	String type;
	Boolean sugar;
	
	// A constructor. It is called when you create a new object.
	public Soda(String type, int price, Boolean sugar) {
		this.type = type;
		this.price = price;
		this.sugar = sugar;
	}
	
	/**
	 * If the sugar is not zero, then return the price. Otherwise, return the price plus 3
	 * 
	 * @return The price of the coffee.
	 */
	public int getPrice() {
		if (!sugar) { // if ZERO
			return price+3;
		} else {
			return price;
		}
	}
	
	/**
	 * This function returns the type of the current object
	 * 
	 * @return The type of the object.
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * If the coffee has sugar, return an empty string. Otherwise, return the string "Zero"
	 * 
	 * @return The method is returning a String.
	 */
	public String getSugarText() {
		if (sugar) {
			return "";
		} else {
			return "Zero";
		}
	}

	/**
	 * If the object is a SodaTypeInterface, then return the flavor string. Otherwise, return an empty
	 * string
	 * 
	 * @return The flavor of the soda.
	 */
	public String getFlavor() {
		try {
			SodaTypeInterface sodaType = (SodaTypeInterface) this;
			return " "+sodaType.getFlavorString();
		} catch (ClassCastException e) {
			return "";
		}
	}
}
