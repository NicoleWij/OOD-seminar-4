package seminar3.integration;

import seminar3.DTO.*;

/**
 * EASHandler, external accounting system handler that fetches and writes data to the accounting database.
 */
public class EASHandler {
    /**
     * Registers a sale and the payment in the accounting system
     * @param payment The payment made by the customer
     * @param sale The sale which contains the date and the items
     */
    public void registerPayment(PaymentDTO payment, SaleDTO sale){
        System.out.println("Registering the payment.");
        System.out.println("Updating inventory.");
    }    
}
