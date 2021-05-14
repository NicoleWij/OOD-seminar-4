package seminar3.integration;

import seminar3.model.Receipt;

/**
 * Printer. This class sends data to an external printer.
 * @param receipt
 */
public class Printer {
    /**
     * This function prints a receipt.
     * @param receipt
     */
    public void printReceipt(Receipt receipt){
        System.out.println("Receipt has been printed.");
    }
}
