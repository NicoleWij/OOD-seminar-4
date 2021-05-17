package se.kth.iv1350.seminar4.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.seminar4.DTO.DiscountDTO;
import se.kth.iv1350.seminar4.DTO.SaleDTO;
import se.kth.iv1350.seminar4.discount.DiscountFinder;

public class DCHandler {
    ArrayList<DiscountDTO> discounts = new ArrayList<DiscountDTO>();

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

    public List<DiscountDTO> findDiscounts(SaleDTO saleDTO, DiscountFinder finder){
        return finder.findDiscount(saleDTO, discounts);
    }
}
