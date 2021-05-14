package se.kth.iv1350.seminar4.view;

import se.kth.iv1350.seminar4.model.SaleObserver;

/**
 * TotalRevenueView
 */
class TotalRevenueView implements SaleObserver{
    private double totalRevenue;

    TotalRevenueView(){
        totalRevenue = 0;
    }

    public void newSale(double priceOfPurchase){
        totalRevenue += priceOfPurchase;
        System.out.println("Total revenue since the program started is: " + totalRevenue);
    }
}
