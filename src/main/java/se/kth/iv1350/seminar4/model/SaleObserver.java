package se.kth.iv1350.seminar4.model;

/**
 * SaleObserver
 */
public interface SaleObserver {

    /**
     * This function is called when a sale is completed
     */
    public void newSale(double priceOfPurchase);
    
}
