package seminar3.DTO;
/**
 * This is a data transfer object class used to transfer the payment made by the customer
 */
public class PaymentDTO {
    private double amount;
    private String currency;

    /**
     * This function creates a new instance of payment data transfer object
     * @param amount the amount the customer pays
     * @param currency the currency in which the customer pays
     */
    public PaymentDTO(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    
    /** 
     * Gets the amount paid by the customer
     * @return int the amount paid
     */
    public double getAmount() {
        return this.amount;
    }


    
    /** 
     * Gets the currency the customer used
     * @return String the currency
     */
    public String getCurrency() {
        return this.currency;
    }   
}
