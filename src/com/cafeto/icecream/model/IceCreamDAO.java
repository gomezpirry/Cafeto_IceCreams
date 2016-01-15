package com.cafeto.icecream.model;

import java.util.HashMap;
import java.util.Map;

/** Class IceCreamDAO . 
 * This class handles the Data Object Access. Here stored in a enum structure implemented with singleton
 */
public enum IceCreamDAO {
	instance;

	private Map<String, IceCream> cream = new HashMap<String, IceCream>();

	private IceCreamDAO() {

		/// Initializate some values
		IceCream ice_cream = new IceCream("1", "Chococono", 3, 1200, "Fresa");
		cream.put("1", ice_cream);
		ice_cream = new IceCream("2", "Paleta", 2, 1500, "Limon");
		cream.put("2", ice_cream);
		ice_cream = new IceCream("3", "Cono", 2, 2500, "Vainilla");
		cream.put("3", ice_cream);

	}

	public Map<String, IceCream> getIceCreams() {
		return cream;
	}

}
