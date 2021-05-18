package se.kth.iv1350.seminar4.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.seminar4.DTO.DiscountDTO;
import se.kth.iv1350.seminar4.DTO.SaleDTO;
import se.kth.iv1350.seminar4.discount.DiscountFinder;


/**
 * DCHandler (Discount Catalogue Handler) handles an external database of discounts.
 * This is currently just a placeholder for an actual database integration.
 */
public class DCHandler {
    ArrayList<DiscountDTO> discounts = new ArrayList<DiscountDTO>();

    /**
     * The different types of discounts. If the amount is below 1, then it is in percentages. If it
     * is above 1, then it is in the currency.
     */
    public DCHandler(){
        discounts.add(
            new DiscountDTO(0.3, 100)
        );
        discounts.add(
            new DiscountDTO("1identifier", 0.2)
        );
        discounts.add(
            new DiscountDTO("2identifier", 0.1)
        );
    }

    /**
     * Finds the discount you're looking for.
     * @param saleDTO The sale where discounts later will be added
     * @param finder The method for finding discounts
     * @return List<DiscountDTO> a list of valid available discounts
     */
    public List<DiscountDTO> findDiscounts(SaleDTO saleDTO, DiscountFinder finder){
        return finder.findDiscount(saleDTO, discounts);
    }
}
