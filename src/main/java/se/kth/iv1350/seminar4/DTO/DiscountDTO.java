package se.kth.iv1350.seminar4.DTO;

/**
 * DiscountDTO
 */
public class DiscountDTO {
    private final String type;
    private String idOfDiscountItem;
    private double discountAmount;
    private double minRequiredPrice;

    public DiscountDTO(String idOfDiscountItem, double discountAmount) {
        type = "item";
        this.idOfDiscountItem = idOfDiscountItem;
        this.discountAmount = discountAmount;
    }

    public DiscountDTO(double discountAmount, double minRequiredPrice) {
        type = "sale";
        this.discountAmount = discountAmount;
        this.minRequiredPrice = minRequiredPrice;
    }


    public String getType() {
        return this.type;
    }


    public String getIdOfDiscountItem() {
        return this.idOfDiscountItem;
    }


    public double getDiscountAmount() {
        return this.discountAmount;
    }

    public double getMinRequiredPrice() {
        return this.minRequiredPrice;
    }
}
