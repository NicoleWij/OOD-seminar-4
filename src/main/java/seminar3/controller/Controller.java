package seminar3.controller;

import seminar3.DTO.ItemDTO;
import seminar3.DTO.PaymentDTO;
import seminar3.DTO.SaleDTO;
import seminar3.DTO.SaleInfoDTO;
import seminar3.integration.*;
import seminar3.model.Sale;
import seminar3.model.Receipt;
import seminar3.model.Register;

/**
 * This is the application's only controller. All calls through the model pass through this class.
 */
public class Controller {
    private Sale sale;
    private EISHandler eis;
    private EASHandler eas;
    private Printer printer;
    private Register register;

    /**
     * This function generates a new instance of the controller
     * @param eis as external inventory handler
     * @param eas as external account system
     * @param printer a printer that prints receipts
     */
    public Controller(EISHandler eis, EASHandler eas, Printer printer){
        this.eis = eis;
        this.eas = eas;
        this.printer = printer;

        this.register = new Register();

        System.out.println("Controller was started successfully. \n");
    }
    

    /**
     * Starts a new sale. This method must be called before doing anything else during a sale.
     */
    public void startSale(){
        this.sale = new Sale();
    }


    /**
     * Adds another item to the sale
     * @param identifier The items identifier. Invalid identifiers are not handled.
     * @return saleInfoDTO information that will be shown on the screen in the view
     */
    public SaleInfoDTO enterItem(String identifier){
        if(sale.checkForDuplicate(identifier)){
            return sale.duplicateIdentifier(identifier);
        }

        ItemDTO item = eis.findItem(identifier);

        return sale.addItem(item);
    }


    /**
     * Handles a payment and also completes the sale, calculates change and updates external systems.
     * @param amount the amount the customer has paid
     * @param currency the currency the customer paid in
     * @return double the amount of change the cashier should give
     */
    public double pay(double amount, String currency){
        PaymentDTO payment = new PaymentDTO(amount, currency);
        SaleDTO sale = this.sale.makeSaleDTO();
        Receipt receipt = this.sale.completeSale(sale, payment);

        register.updateAmount(amount);

        eis.updateInventory(sale);
        eas.registerPayment(payment, sale);
        printer.printReceipt(receipt);

        return (amount - sale.getTotalPrice());
    }
}