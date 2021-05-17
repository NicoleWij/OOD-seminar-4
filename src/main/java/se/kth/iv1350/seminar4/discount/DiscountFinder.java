package se.kth.iv1350.seminar4.discount;

import java.util.List;

import se.kth.iv1350.seminar4.DTO.*;

/**
 * DiscountFinder
 */
public interface DiscountFinder {

    List<DiscountDTO> findDiscount(SaleDTO saleDTO, List<DiscountDTO> availableDiscounts);

}