package se.kth.iv1350.seminar4.view;

import se.kth.iv1350.seminar4.DTO.SaleInfoDTO;
import se.kth.iv1350.seminar4.controller.Controller;
import se.kth.iv1350.seminar4.integration.ItemNotFoundException;
import se.kth.iv1350.seminar4.integration.ServerDownException;

/**
 * This is a placeholder for the real view. It contains a hardcoded execution with calls 
 * to all system operations in the controller.
 */
public class View {
    private Controller contr;
    private int amount = 100;
    private String currency = "SEK";

    /**
     * Creates a new instance, that uses the specified controller for all calls to other layers
     * @param contr The controller to use for all calls to other layers.
     */
    public View(Controller contr) {
        this.contr = contr;
        contr.addSaleObserver(new TotalRevenueView());
        contr.addSaleObserver(new TotalRevenueFileOutput());
    }

    /**
     * Performs a fake sale, by calling all system operations in the controller.
     */
    public void runFakeExecution(){
        contr.startSale();
        System.out.println("A new sale has started successfully.");

        try {
            contr.enterItem("ServerDownIdentifier");
            SaleInfoDTO saleInfo = contr.enterItem("ServerDownIdentifier");
            System.out.println("Added an item with the identifier: ServerDownIdentifier");
            System.out.println("\nItem: " + saleInfo.getCurrentItemName());
            System.out.println("Item price: " + saleInfo.getCurrentItemPrice() + "\n");

        } catch (ItemNotFoundException exc) {
            System.err.println("Invalid identifier entered, no item found.");

        } catch (ServerDownException exc) {
            System.err.println("Database cannot be called, server is down.");

        }

        contr.applyDiscount();
        System.out.println("\nLooking for and applying discounts.");

        System.out.println("A payment of 100 SEK was made\n");
        double change = contr.pay(amount, currency);
	    System.out.println("\nChange: " + change + " SEK");

        System.out.println("\n");
    }
}