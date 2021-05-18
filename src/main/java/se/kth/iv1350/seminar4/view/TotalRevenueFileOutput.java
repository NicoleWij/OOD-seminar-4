package se.kth.iv1350.seminar4.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import se.kth.iv1350.seminar4.model.SaleObserver;

/**
 * TotalRevenueFileOutput prints the total income since the program started to a file.
 */
class TotalRevenueFileOutput implements SaleObserver {
    private PrintWriter logFile;
    private double totalRevenue;
    
    /**
     * Generates a new isntance of the TotalRevenueFileOutput class
     */
    TotalRevenueFileOutput() {
        totalRevenue = 0;

        try {
            logFile = new PrintWriter(new FileWriter("total-revenue.txt"), true);
        } catch (IOException ex) {
            System.out.println("Could not create logger.");
            ex.printStackTrace();
        }
    }
    
    @Override
    public void newSale(double priceOfPurchase){
        totalRevenue += priceOfPurchase;
        logFile.println("Total revenue: " + totalRevenue);
    }
}
