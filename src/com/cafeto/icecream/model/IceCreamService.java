package com.cafeto.icecream.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;



/** Class IceCreamService. 
 *  In this class are added all function that operate the data structure
 */
public class IceCreamService {

	IceCreamDAO creamDAO;

	/** IceCreamService Constructor . 
	 * 
	 */
	public IceCreamService() {
		creamDAO = IceCreamDAO.instance;
	}

	/** Function createIceCream() . 
	 * This function store a new instance of ice cream in the data structure  
	 */
	public void createIceCream(IceCream cream) {
		creamDAO.getIceCreams().put(cream.getId(), cream);
	}

	public IceCream getIceCream(String id) {
		return creamDAO.getIceCreams().get(id);
	}

	public Map<String, IceCream> getIceCreams() {
		return creamDAO.getIceCreams();
	}
	
	/** Function getIceCreamAsList() . 
	 * This function returns all ice creams  
	 */
	public List<IceCream> getIceCreamAsList() {
		List<IceCream> IceCreamList = new ArrayList<IceCream>();
		IceCreamList.addAll(creamDAO.getIceCreams().values());
		return IceCreamList;
	}

	/** Function getIceCreamAsSortList(). 
	 * This function returns all ice creams order alphabetically by name 
	 */
	public List<IceCream> getIceCreamAsSortList() {
		List<IceCream> IceCreamList = new ArrayList<IceCream>();
		Collection<IceCream> values = creamDAO.getIceCreams().values();
	    IceCream[] creams= values.toArray(new IceCream[values.size()]);		
		
		for(int i= 0; i<creams.length-1; i++)
			for(int j= 0; j< creams.length-i-1;j++) 
				if (creams[j+1].getName().compareTo(creams[j].getName()) <= 0){
					IceCream aux = creams[j+1]; 
					creams[j+1] = creams[j]; 
					creams[j]= aux; 
				}
		for(int i= 0; i<creams.length-1; i++)
			IceCreamList.add(creams[i]);	
		return IceCreamList;
	}

	/** Function getIceCreamCount(). 
	 * This function count all ice creams 
	 */
	public int getIceCreamCount() {
		return creamDAO.getIceCreams().size();
	}

	/** Function getIceCreamCostCount. 
	 * This function count the ice creams that overcome a given cost 
	 */
	public int getIceCreamCostCount(int costTh) {
		int count = 0;
		List<IceCream> values = new ArrayList<IceCream>();
		values.addAll(creamDAO.getIceCreams().values());
	    for(int i = 0; i < values.size(); i++)
	    	if(values.get(i).getCost() > costTh)
	    		count++;
	    return count;
	}
	
	/** Function getIceCreamInStock. 
	 * This function obtain the ice creams with more amount that indicates by the user
	 */
	public List<IceCream> getIceCreamInStock(int amount){
		List<IceCream> IceCreamList = new ArrayList<IceCream>();
		List<IceCream> values = new ArrayList<IceCream>();
		values.addAll(creamDAO.getIceCreams().values());
		for(int i = 0; i < values.size(); i++)
			 if(values.get(i).getAmount() > amount)
				 IceCreamList.add(values.get(i));
		
		return IceCreamList;
	}
	
	
	public void deleteIceCream(String id) {
		creamDAO.getIceCreams().remove(id);
	}

}
