package se.kth.iv1350.seminar4.model;

import se.kth.iv1350.seminar4.DTO.*;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

/**
 * One single sale made by one single customer and payed with one payment
 */
public class Sale {
    private LocalTime timeOfSale;
    private ArrayList<Item> items = new ArrayList<Item>();
    private double totalPrice;
    private double totalVAT;
    private List<SaleObserver> saleObservers = new ArrayList<>();

    /**
     * Creates a new instance and saves the time of the sale.
     */
    public Sale(){
        timeOfSale = LocalTime.now();
    }


    private void updateRunningTotal(){
        double runningTotal = 0;
        double totalVAT = 0;

        for(Item item : items){
            runningTotal += item.getPrice() * item.getQuantity();
            totalVAT += item.getVAT() * item.getPrice() * item.getQuantity();
        }

        this.totalVAT = totalVAT;
        this.totalPrice = runningTotal;
    }
    
    /** 
     * This function adds a new item to the item list of the sale
     * @param itemDTO the item to be added
     * @return SaleInfoDTO information shown in the view
     */
    public SaleInfoDTO addItem(ItemDTO itemDTO){
        Item item = new Item(itemDTO);
        items.add(item);
        updateRunningTotal();

        SaleInfoDTO saleInformation = new SaleInfoDTO(item, this.totalPrice);

        return saleInformation;
    }

    
    /** 
     * This function will complete the sale.
     * @param payment the customers payment
     * @param sale the current sale
     * @param Receipt the generated receipt for the sale
     */
    public Receipt completeSale(SaleDTO sale, PaymentDTO payment){
        notifyObservers();
        return new Receipt(sale, payment);
    }

    private void notifyObservers(){
        for(SaleObserver obs : saleObservers) {
            obs.newSale(totalPrice);
        }
    }

    /**
     * Adds an observer that will be notified when a sale is completed. 
     * @param obs The observer to notify. 
     */
    public void addSaleObserver(SaleObserver obs) {
        saleObservers.add(obs);
    }

    
    /** 
     * This function will increase the quantity of an identifier that matches one already scanned
     * @param identifier the identifier compared to the other identifiers already scanned
     * @return SaleInfoDTO Information about the sale that will be sent back to the view
     */
    public SaleInfoDTO duplicateIdentifier(String identifier){
        for(Item item : items){
            if(item.getIdentifier().equals(identifier)){
                item.increaseQuantity();
                return new SaleInfoDTO(item, this.totalPrice);
            }
        }
        return null;
    }

    
    /** 
     * This function will check if an item with the same identifier already has been scanned 
     * @param identifier The identifier of the current item
     * @return boolean if the identifier has been scanned before or not
     */
    public boolean checkForDuplicate(String identifier){
        for(Item item : items){
            if(identifier.equals(item.getIdentifier())){
                return true;
            }
        }
        return false;
    }


    /** 
     * This function converts a sale to a saleDTO so that it can be sent to external systems
     * @return SaleDTO the same sale but DTO version
     */
    public SaleDTO makeSaleDTO() {
        SaleDTO thisSale = new SaleDTO(this.timeOfSale, this.items, this.totalPrice, this.totalVAT);

        return thisSale;
    }


    /** 
     * This function gets the time of the sale
     * @return LocalTime time of the sale
     */
    public LocalTime getTimeOfSale() {
        return this.timeOfSale;
    }

    
    /** 
     * This function gets the totalPrice
     * @return double total price of the sale
     */
    public double getTotalPrice() {
        return this.totalPrice;
    }

    
    /** 
     * Gets the total VAT of the sale
     * @return double the total VAT
     */
    public double getTotalVAT() {
        return this.totalVAT;
    }

    
    /** 
     * Gets all the scanned items
     * @return ArrayList<Item> the items in an arraylist
     */
    public ArrayList<Item> getItems() {
        return this.items;
    }

    
    /**
     * Updates the item prices of the sale after applying discounts
     * @param discounts The discount
     */
    public void applyItemDiscounts(List<DiscountDTO> discounts){
        for(DiscountDTO discount : discounts){
            for(Item item : items) {
                if(item.getIdentifier().equals(discount.getIdOfDiscountItem())){
                    item.applyDiscount(discount);
                }
            }
        }
    }


    /**
     * This function will change the total price after applying the discount.
     * @param discounts
     */
    public void applyDiscount(List<DiscountDTO> discounts) {
        for (DiscountDTO discount : discounts){
            if (discount.getDiscountAmount() < 1){
                totalPrice *= 1 - discount.getDiscountAmount();
            }
            else {
                totalPrice -= discount.getDiscountAmount();
            }

        }
    }
}
