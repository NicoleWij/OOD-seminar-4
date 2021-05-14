package se.kth.iv1350.seminar4.integration;

/**
 * ServerDownException is thrown when the database cannot be called, 
 * when the external database is down
 */
public class ServerDownException extends Exception {
    /**
     * This function creates a new instance of the ServerDownException
     * @param message The message that the exception takes in
     */
    public ServerDownException(String message) {
        super(message);
    }
}