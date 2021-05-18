package se.kth.iv1350.seminar4.discount;

import java.util.List;

import se.kth.iv1350.seminar4.DTO.*;

/**
 * DiscountFinder is an interface that is used to find discounts. Different implementations
 * of the interface can find discounts in different ways.
 */
public interface DiscountFinder {

    List<DiscountDTO> findDiscount(SaleDTO saleDTO, List<DiscountDTO> availableDiscounts);

}