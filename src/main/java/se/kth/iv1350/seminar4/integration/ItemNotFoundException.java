package se.kth.iv1350.seminar4.integration;

/**
 * ItemNotFoundException if an invalid identifier is entered, that is if the item is not '
 * on the list of items.
 */
public class ItemNotFoundException extends Exception {
    /**
     * This function creates a new instance of the ItemNotFoundException
     * @param message The message that the exception takes in
     */
    public ItemNotFoundException(String message){
        super(message);
    }
    
}
