package drinkCrate;

public class SevenUp extends Soda implements SodaTypeInterface {

	// Calling the super class constructor.
	public SevenUp(String type, Boolean sugar) {
		super(type, 35, sugar);
	}

	@Override
	// A method that is required to be implemented by the SodaTypeInterface.
	public String getFlavorString() {
		// TODO Auto-generated method stub
		return "";
	}
}
