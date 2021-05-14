package seminar3.model;

/**
 * Virtual register used for keeping track of the money
 */
public class Register {
    double amount;

    /**
     * This function generates a new instance of a register
     */
    public Register(){
        this.amount = 1000;
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
