package seminar3.DTO;

import java.time.LocalTime;
import java.util.ArrayList;

import seminar3.model.Item;
/**
 * A data transfer object class used to send the sale to external systems.
 */
public class SaleDTO {
    private LocalTime timeOfSale;
    private ArrayList<Item> items;
    private double totalPrice;
    private double totalVAT;

    /**
     * This function creates a new sale data transfer object
     * @param time the time of the start of the sale
     * @param items all the items of the sale
     * @param totalPrice the total price of the items
     * @param totalVAT the total VAT of all the items
     */
    public SaleDTO(LocalTime time, ArrayList<Item> items, double totalPrice, double totalVAT) {
        this.timeOfSale = time;
        this.items = items;
        this.totalPrice = totalPrice;
        this.totalVAT = totalVAT;
    }
    
    /** 
     * Gets the time the sale was started
     * @return LocalTime the time
     */
    public LocalTime getTimeOfSale() {
        return this.timeOfSale;
    }
    
    /** 
     * Gets all the scanned items of sale
     * @return ArrayList<Item> the items
     */
    public ArrayList<Item> getItems() {
        return this.items;
    }
    
    /** 
     * Gets the total price of all scanned items
     * @return double the total price
     */
    public double getTotalPrice() {
        return this.totalPrice;
    }
    
    /** 
     * Gets the total VAT for all the scanned items
     * @return double the total VAT
     */
    public double getTotalVAT() {
        return this.totalVAT;
    }
}
