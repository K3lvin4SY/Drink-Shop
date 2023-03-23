package drinkCrate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Crate {
	private String sizeString;
	private int iSize;
	private int jSize;
	private int amount;
	private HashMap<String, HashMap<String, Soda>> storage;

	// Creating a new crate with the size of the string.
	public Crate(String size) {
		this.iSize = Integer.parseInt(size.split("x")[0]);
		this.jSize = Integer.parseInt(size.split("x")[1]);
		this.sizeString = size;
		this.amount = 1;
		this.storage = new HashMap<String, HashMap<String, Soda>>();
		for (int i = 1; i <= iSize; i++) {
			HashMap<String, Soda> innerHashMap = new HashMap<String, Soda>();
			for (int j = 1; j <= jSize; j++) {
				innerHashMap.put(j+"", null);
			}
			storage.put(i+"", innerHashMap);
		}
	}
	
	/**
	 * This function sets the amount of the item
	 * 
	 * @param amount The amount of the item to be added to the cart.
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	/**
	 * This function takes in a row and column number, and a soda object, and inserts the soda object into
	 * the storage hashmap at the given row and column
	 * 
	 * @param i the row
	 * @param j the row
	 * @param soda The soda object to be inserted
	 */
	public void insertSoda(int i, int j, Soda soda) {
		HashMap<String, Soda> inner = storage.get(i+"");
		inner.replace(j+"", soda);
		storage.replace(i+"", inner);
	}
	
	/**
	 * This function returns the size of the pizza
	 * 
	 * @return The size of the pizza.
	 */
	public String getSize() {
		return sizeString;
	}
	
	/**
	 * For each outer entry in the storage map, for each inner entry in the outer entry's value, if the
	 * inner entry's value is not null, increment the amount variable
	 * 
	 * @return The amount of sodas in the vending machine.
	 */
	public int getSodaAmount() {
		int amount = 0;
		for (Entry<String, HashMap<String, Soda>> outer : storage.entrySet()) {
			for (Entry<String, Soda> inner : outer.getValue().entrySet()) {
				if (inner.getValue() != null) {
					amount++;
				}
			}
		}
		return amount;
	}
	
	/**
	 * This function returns the number of soda types in the vending machine
	 * 
	 * @return The number of soda types.
	 */
	public int getSodaTypesAmount() {
		ArrayList<String> types = getSodaTypes();
		return types.size();
	}
	
	/**
	 * This function returns an ArrayList of Strings that contains all the types of soda in the vending
	 * machine
	 * 
	 * @return The method is returning an ArrayList of Strings.
	 */
	public ArrayList<String> getSodaTypes() {
		ArrayList<String> types = new ArrayList<String>();
		for (Entry<String, HashMap<String, Soda>> outer : storage.entrySet()) {
			for (Entry<String, Soda> inner : outer.getValue().entrySet()) {
				if (inner.getValue() != null) {
					if (!types.contains(inner.getValue().getType())) {
						types.add(inner.getValue().getType());
					}
				}
			}
		}
		return types;
	}

	/**
	 * This function returns the soda type at the given index
	 * 
	 * @param i The index of the soda type you want to get.
	 * @return The soda type at the given index.
	 */
	public String getSodaType(int i) {
		ArrayList<String> types = getSodaTypes();
		return types.get(i);
	}

	/**
	 * It returns the amount of sodas of a certain type
	 * 
	 * @param i The index of the soda type you want to get the amount of.
	 * @return The amount of sodas of a certain type.
	 */
	public int getSodaTypeAmount(int i) {
		String type = getSodaType(i);
		int amount = 0;
		for (Entry<String, HashMap<String, Soda>> outer : storage.entrySet()) {
			for (Entry<String, Soda> inner : outer.getValue().entrySet()) {
				if (inner.getValue() != null) {
					if (inner.getValue().getType().equals(type)) {
						amount++;
					}
				}
			}
		}
		return amount;
	}

	/**
	 * It returns the amount of sodas of a certain type that are in the storage
	 * 
	 * @param type The type of soda you want to get the amount of.
	 * @return The amount of sodas of a certain type.
	 */
	public int getSodaTypeAmount(String type) {
		int amount = 0;
		if (getSodaTypes().contains(type)) {
			for (Entry<String, HashMap<String, Soda>> outer : storage.entrySet()) {
				for (Entry<String, Soda> inner : outer.getValue().entrySet()) {
					if (inner.getValue() != null) {
						if (inner.getValue().getType().equals(type)) {
							amount++;
						}
					}
				}
			}
		}
		return amount;
	}

	/**
	 * This function returns the total cost of all sodas of a given type
	 * 
	 * @param i The index of the soda type
	 * @return The total cost of all sodas of a certain type.
	 */
	public int getSodaTypeCost(int i) {
		String type = getSodaType(i);
		int amount = 0;
		for (Entry<String, HashMap<String, Soda>> outer : storage.entrySet()) {
			for (Entry<String, Soda> inner : outer.getValue().entrySet()) {
				if (inner.getValue() != null) {
					if (inner.getValue().getType().equals(type)) {
						amount += inner.getValue().getPrice();
					}
				}
			}
		}
		return amount;
	}
	
	/**
	 * This function returns the total cost of all sodas of a given type
	 * 
	 * @param type The type of soda you want to get the cost of.
	 * @return The total cost of all sodas of a given type.
	 */
	public int getSodaTypeCost(String type) {
		int amount = 0;
		if (getSodaTypes().contains(type)) {
			for (Entry<String, HashMap<String, Soda>> outer : storage.entrySet()) {
				for (Entry<String, Soda> inner : outer.getValue().entrySet()) {
					if (inner.getValue() != null) {
						if (inner.getValue().getType().equals(type)) {
							amount += inner.getValue().getPrice();
						}
					}
				}
			}
		}
		return amount;
	}
	
	/**
	 * For each entry in the outer HashMap, for each entry in the inner HashMap, if the value is not null,
	 * add the price of the soda to the amount
	 * 
	 * @return The total cost of all the sodas in the vending machine.
	 */
	public int getTotalCost() {
		int amount = 0;
		for (Entry<String, HashMap<String, Soda>> outer : storage.entrySet()) {
			for (Entry<String, Soda> inner : outer.getValue().entrySet()) {
				if (inner.getValue() != null) {
					amount += inner.getValue().getPrice();
				}
			}
		}
		return amount;
	}

	/**
	 * This function returns the amount of money in the account
	 * 
	 * @return The amount of the item.
	 */
	public int getAmount() {
		return amount;
	}
}
