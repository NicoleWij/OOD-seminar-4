package se.kth.iv1350.seminar4.model;

/**
 * Virtual register used for keeping track of the money
 */
public class Register {
    double amount;

    /**
     * Private constructor
     */
    private Register(){
        this.amount = 1000;
    }


    /**
     * This function updates the current instance of Register instead of creating
     * a new one
     */
    private static class RegisterHolder {
        private static Register instance = new Register();
    }


    /**
     * This method gets the register.
     * @return Register the register
     */
    public static Register getInstance() {
        return RegisterHolder.instance;
    }

    /**
     * Gets and returns the amount in the register
     * @return double the amount of money in the register (double)
     */
    public double getAmount(){
        return amount;
    }

    /**
     * Updates the amount in the register
     * @param amount the relative change of the amount.
     */
    public void updateAmount(double amount){
        this.amount += amount;
    }
}
