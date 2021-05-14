package seminar3.model;

import seminar3.DTO.*;

public class Item {
    private int quantity;
    private String name;
    private double VAT;
    private double price;
    private String description;
    private String identifier;

    /**
     * This function creates a new instance of the Item class
     * @param item the item DtO to be converted
     */
    public Item(ItemDTO item){
        this.VAT = item.getVAT();
        this.price = item.getPrice();
        this.description = item.getDescription();
        this.identifier = item.getIdentifier();
        this.quantity = 1;
    }

    
    /** 
     * Returns the quantity of a specific item
     * @return int the quantity
     */
    public int getQuantity(){
        return this.quantity;
    }

    
    /** 
     * Returns the name of the item
     * @return String the name
     */
    public String getName(){
        return this.name;
    }

    
    /** 
     * Returns the VAT of the item
     * @return double the VAT
     */
    public double getVAT(){
        return this.VAT;
    }

    
    /** 
     * Returns the price of the item
     * @return double the price
     */
    public double getPrice(){
        return this.price;
    }

    
    /** 
     * Returns the description of the item
     * @return String the description
     */
    public String getDescription(){
        return this.description;
    }

    
    /** 
     * Returns the identifier of the item
     * @return String the identifier
     */
    public String getIdentifier(){
        return this.identifier;
    }

    
    /**
     * Increases the item quantity
     * @return int the quantity
     */
    public void increaseQuantity() {
        quantity += 1;
    }
}
