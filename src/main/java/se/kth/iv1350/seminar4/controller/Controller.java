package se.kth.iv1350.seminar4.controller;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.seminar4.DTO.*;
import se.kth.iv1350.seminar4.discount.*;
import se.kth.iv1350.seminar4.integration.*;
import se.kth.iv1350.seminar4.model.*;

/**
 * This is the application's only controller. All calls through the model pass through this class.
 */
public class Controller {
    private Sale sale;
    private EISHandler eis;
    private EASHandler eas;
    private DCHandler dc;
    private Printer printer;
    private Register register;
    private List<SaleObserver> saleObservers = new ArrayList<>();


    /**
     * This function generates a new instance of the controller
     * @param eis as external inventory handler
     * @param eas as external account system
     * @param printer a printer that prints receipts
     */
    public Controller(EISHandler eis, EASHandler eas, Printer printer, DCHandler dc) {
        this.eis = eis;
        this.eas = eas;
        this.printer = printer;
        this.dc = dc;

        this.register = Register.getInstance();

        System.out.println("Controller was started successfully. \n");
    }
    

    /**
     * Starts a new sale. This method must be called before doing anything else during a sale.
     */
    public void startSale() {
        this.sale = new Sale();
        for(SaleObserver obs : saleObservers){
            sale.addSaleObserver(obs);
        }
    }


    /**
     * Adds another item to the sale
     * @param identifier The items identifier. Invalid identifiers are not handled.
     * @return saleInfoDTO information that will be shown on the screen in the view
     * @throws ItemNotFoundException throws an exception when the item identifier is invalid
     * @throws ServerDownException  throws an exception when the server is down
     */
    public SaleInfoDTO enterItem(String identifier) throws ItemNotFoundException, ServerDownException {
        if(sale.checkForDuplicate(identifier)){
            return sale.duplicateIdentifier(identifier);
        }
        
        try {
            ItemDTO item = eis.findItem(identifier);
            return sale.addItem(item);
            
        } catch (ItemNotFoundException | ServerDownException exc) {
            System.out.println("FOR DEVELOPERS: " + exc.getMessage());
            throw exc;
        }
    }

    /**
     * applies the discount based on what the customer has purchased.
     * @return double the newly updated running total.
     */
    public double applyDiscount() {
        SaleDTO saleDTO = this.sale.makeSaleDTO();
        List<DiscountDTO> itemDiscounts = dc.findDiscounts(saleDTO, new ItemDiscount());
        List<DiscountDTO> saleDiscounts = dc.findDiscounts(saleDTO, new SaleDiscount());

        sale.applyItemDiscounts(itemDiscounts);
        sale.applyDiscount(saleDiscounts);

        return saleDTO.getTotalPrice();
    }


    /**
     * Handles a payment and also completes the sale, calculates change and updates external systems.
     * @param amount the amount the customer has paid
     * @param currency the currency the customer paid in
     * @return double the amount of change the cashier should give
     */
    public double pay(double amount, String currency) {
        PaymentDTO payment = new PaymentDTO(amount, currency);
        SaleDTO sale = this.sale.makeSaleDTO();
        Receipt receipt = this.sale.completeSale(sale, payment);

        register.updateAmount(amount);

        eis.updateInventory(sale);
        eas.registerPayment(payment, sale);
        printer.printReceipt(receipt);

        return (amount - sale.getTotalPrice());
    }

    /**
     * The spevified observer will be added to the saleObservers arrayList
     * @param obs the saleObserver
     */
    public void addSaleObserver(SaleObserver obs) {
        saleObservers.add(obs);
    }
}