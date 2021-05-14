package seminar3.DTO;

/**
 * A data transfer object class that is used to transfer items
 */
public class ItemDTO{
    private String description;
    private double VAT;
    private double price;
    private String name;
    private String identifier;

    
    /** 
     * This function creates a new instance of an item data transfer object
     * @param description a description of the item
     * @param VAT the VAT of the item
     * @param price the price of the item
     * @param name the name of the item
     */
    public ItemDTO(String description, double VAT, double price, String name, String identifier){
        this.description = description;
        this.VAT = VAT;
        this.price = price;
        this.name = name;
        this.identifier = identifier;
    }

    
    /** 
     * Gets the description of the tiem
     * @return String the description
     */
    public String getDescription(){
        return this.description;
    }

    
    /** 
     * Gets the VAT of the item
     * @return double the VAT
     */
    public double getVAT(){
        return this.VAT;
    }

    
    /** 
     * gets the Price of the item
     * @return double the price
     */
    public double getPrice(){
        return this.price;
    }

    
    /** 
     * Gets the name of the item
     * @return String the name
     */
    public String getName(){
        return this.name;
    }

    
    /** 
     * Gets the identifier of the item
     * @return String the identifier
     */
    public String getIdentifier(){
        return this.identifier;
    }
}