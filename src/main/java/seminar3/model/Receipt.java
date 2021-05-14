package seminar3.model;

import java.time.LocalTime;
import java.util.ArrayList;

import seminar3.DTO.*;

/**
 * Represents one receipt, which proves the payment of one sale.
 */
public class Receipt {
    private LocalTime timeOfSale;
    private ArrayList<Item> items = new ArrayList<Item>();
    private double totalPrice;
    private double totalVAT;
    private double paidAmount;
    private String currency;
    private String storeInformation = "Information about store xoxo";

    public Receipt(SaleDTO sale, PaymentDTO payment) {
        this.timeOfSale = sale.getTimeOfSale();
        this.items = sale.getItems();
        this.totalPrice = sale.getTotalPrice();
        this.totalVAT = sale.getTotalVAT();
        this.paidAmount = payment.getAmount();
        this.currency = payment.getCurrency();
    }

    
    /** 
     * Returns the time of the sale when it starts
     * @return LocalTime, the time the sale starts
     */
    public LocalTime getTimeOfSale() {
        return this.timeOfSale;
    }

    
    /** 
     * Returns a list of the purchased items in the sale
     * @return ArrayList<Item> The items
     */
    public ArrayList<Item> getItems() {
        return this.items;
    }

    
    /** 
     * Returns the total price of the sale
     * @return double the total price
     */
    public double getTotalPrice() {
        return this.totalPrice;
    }

    
    /** 
     * Returns the total VAT of the sale
     * @return double the total VAT
     */
    public double getTotalVAT() {
        return this.totalVAT;
    }

    
    /** 
     * Returns the total amount paid by the customer
     * @return double the amount paid
     */
    public double getPaidAmount() {
        return this.paidAmount;
    }

    
    /** 
     * Returns the currency
     * @return String The currency
     */
    public String getCurrency() {
        return this.currency;
    }

    
    /**
     * Returns information about the store
     * @return String the information
     */
    public String getStoreInformation() {
        return this.storeInformation;
    }
}
