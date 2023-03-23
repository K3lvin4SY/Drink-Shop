package drinkCrate;

public class Cola extends Soda implements SodaTypeInterface {

	// Calling the constructor of the super class.
	public Cola(String type, Boolean sugar) {
		super(type, 44, sugar);
	}

	@Override
	// A method that is required by the SodaTypeInterface.
	public String getFlavorString() {
		// TODO Auto-generated method stub
		return "";
	}

}
