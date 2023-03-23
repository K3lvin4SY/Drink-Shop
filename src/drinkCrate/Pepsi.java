package drinkCrate;

public class Pepsi extends Soda implements SodaTypeInterface {

	// Calling the constructor of the parent class.
	public Pepsi(String type, Boolean sugar) {
		super(type, 38, sugar);
	}

	@Override
	// A method that is required to be implemented by the SodaTypeInterface.
	public String getFlavorString() {
		// TODO Auto-generated method stub
		return "";
	}
}
