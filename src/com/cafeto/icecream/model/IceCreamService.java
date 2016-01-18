package com.cafeto.icecream.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/** Class IceCreamService. 
 *  In this class are added all function that operate the data structure
 */
public class IceCreamService {

	IceCreamDAO creamDAO;
	private IceCream[] array;
    private int length;

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
		System.out.println(IceCreamList.toString());
		return IceCreamList;
	}

	/** Function getIceCreamAsSortList(). 
	 * This function returns all ice creams order alphabetically by name 
	 */
	public List<IceCream> getIceCreamAsSortList() {
		List<IceCream> IceCreamList = new ArrayList<IceCream>();
		IceCreamList.addAll(creamDAO.getIceCreams().values());
		array = new IceCream[IceCreamList.size()];

	    for(int i = 0; i< IceCreamList.size();i++)
	    	array[i] = IceCreamList.get(i);   
	    
        this.length = array.length;
        calcQuickSort(0, length - 1);
        return Arrays.asList(array);
    }      
 
    /** calcQuickSort. Auxiliar function to performed quicksort
     * 
     */
    private  void calcQuickSort(int lowerIndex, int higherIndex) {
        
        int i = lowerIndex;
        int j = higherIndex;
        String pivot = array[lowerIndex+(higherIndex-lowerIndex)/2].getName();

        while (i <= j) {
           while (array[i].getName().compareTo(pivot) < 0) 
                i++;
            
            while (array[j].getName().compareTo(pivot) > 0)
                j--;
        
            if (i <= j) {
                exchangeValues(i, j);
                i++;
                j--;
            }
        }

        if (lowerIndex < j)
            calcQuickSort(lowerIndex, j);
        if (i < higherIndex)
            calcQuickSort(i, higherIndex);
    }

    private  void exchangeValues(int i, int j) {
        IceCream temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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
