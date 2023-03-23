package drinkCrate;

public class Sprite extends Soda implements SodaTypeInterface {

	// Calling the constructor of the super class.
	public Sprite(String type, Boolean sugar) {
		super(type, 40, sugar);
	}

	@Override
	// A method that is required by the SodaTypeInterface.
	public String getFlavorString() {
		// TODO Auto-generated method stub
		return "";
	}
}
