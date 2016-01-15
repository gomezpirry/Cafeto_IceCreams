package com.cafeto.icecream.model;

import javax.xml.bind.annotation.XmlRootElement;


/** Class IceCream. 
 * This class contains the model of ice cream object 
 */
@XmlRootElement
public class IceCream {
	private String id;
	private String name;
	private int amount;
	private int cost;
	private String flavor;

	public IceCream() {

	}

	public IceCream(String id, String name, int amount, int cost, String flavor) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.cost = cost;
		this.flavor = flavor;
	}

	/** Getter and Setter function of ice cream model. 
	 * 
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

}