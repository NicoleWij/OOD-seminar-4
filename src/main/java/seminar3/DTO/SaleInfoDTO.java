package seminar3.DTO;

import seminar3.model.Item;
/**
 * A data transfer object class used to transfer information regarding the lastest scanned item
 */
public class SaleInfoDTO {
    private String currentItemDescription;
    private double currentItemPrice;
    private String currentItemName;
    private double runningTotal;

    /**
     * This function creates a new instance of a sale into a data transfer object
     * @param item
     * @param runningTotal
     */
    public SaleInfoDTO(Item item, double runningTotal){
        this.currentItemDescription = item.getDescription();
        this.currentItemPrice = item.getPrice();
        this.currentItemName = item.getName();
        this.runningTotal = runningTotal;
    }

    
    /** 
     * Gets the description of the last scanned item
     * @return String the description
     */
    public String getItemDescription(){
        return this.currentItemDescription;
    }

    
    /** 
     * Gets the price of the last scanned item
     * @return double the price
     */
    public double getCurrentItemPrice(){
        return this.currentItemPrice;
    }

    
    /** 
     * Gets the name of the last scanned item
     * @return String the name
     */
    public String getCurrentItemName(){
        return this.currentItemName;
    }   

    
    /** 
     * Gets the total price of all the scanned items so far
     * @return double the running total
     */
    public double getRunningTotal(){
        return this.runningTotal;
    }   
}
