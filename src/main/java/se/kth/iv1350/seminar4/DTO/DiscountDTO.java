package se.kth.iv1350.seminar4.DTO;

/**
 * This class is used for sending discounts throughout the program.
 */
public class DiscountDTO {
    private String type;
    private String idOfDiscountItem;
    private double discountAmount;
    private double minRequiredPrice;

    /**
     * This function creates a new instance of the discountDTO, which in this case is of the type
     * item and should be used for discounting specific items.
     * @param idOfDiscountItem the identifier of the targeted item
     * @param discountAmount the amount which the item is discounted with. If the amount is less than 1
     * it is read as a discount percentage, otherwise it is read as an amount to subtract form the
     * original price.
     */
    public DiscountDTO(String idOfDiscountItem, double discountAmount) {
        type = "item";
        this.idOfDiscountItem = idOfDiscountItem;
        this.discountAmount = discountAmount;
    }


    /**
     * This function creates a new instance of the discountDTO lass. It creates a sale discount which
     * should be used for applying on an entire sale.
     * @param idOfDiscountItem the identifier of the targeted item
     * @param discountAmount the amount which the item is discounted with. If the amount is less than 1
     * it is read as a discount percentage, otherwise it is read as an amount to subtract form the
     * original price.
     */
    public DiscountDTO(double discountAmount, double minRequiredPrice) {
        type = "sale";
        this.discountAmount = discountAmount;
        this.minRequiredPrice = minRequiredPrice;
    }


    
    /** 
     * Gets the type of discount, which is either "sale" or "item".
     * @return String The type of discount
     */
    public String getType() {
        return this.type;
    }


    
    /** 
     * Gets the identifier of the discounted item (only used for item discounts)
     * @return String the identifier
     */
    public String getIdOfDiscountItem() {
        return this.idOfDiscountItem;
    }


    
    /** 
     * Gets how much the discount should reduce the price. If the amount is less than one, it is
     * read as a percentage.
     * @return double the amount
     */
    public double getDiscountAmount() {
        return this.discountAmount;
    }

    
    /** 
     * Gets the minimum required sale price for the discount to be valid
     * @return double the minimum price
     */
    public double getMinRequiredPrice() {
        return this.minRequiredPrice;
    }
}
