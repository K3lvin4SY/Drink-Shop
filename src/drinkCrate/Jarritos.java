package drinkCrate;

public class Jarritos extends Soda implements SodaTypeInterface {

	// Calling the super class constructor.
	public Jarritos(String type, Boolean sugar) {
		super(type, 20, sugar);
	}

	@Override
	// A method that is required to be implemented by the SodaTypeInterface.
	public String getFlavorString() {
		// TODO Auto-generated method stub
		return "";
	}

}
