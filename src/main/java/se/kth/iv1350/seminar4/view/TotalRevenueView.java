package se.kth.iv1350.seminar4.view;

import se.kth.iv1350.seminar4.model.SaleObserver;

/**
 * TotalRevenueView This class writes to the console when it's been notified
 */
class TotalRevenueView implements SaleObserver{
    private double totalRevenue;

    /**
     * Creates a new instance of totalRevenueView class
     */
    TotalRevenueView(){
        totalRevenue = 0;
    }

    @Override
    public void newSale(double priceOfPurchase){
        totalRevenue += priceOfPurchase;
        System.out.println("Total revenue since the program started is: " + totalRevenue);
    }
}
