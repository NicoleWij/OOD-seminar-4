package se.kth.iv1350.seminar4.startup;

import se.kth.iv1350.seminar4.controller.Controller;
import se.kth.iv1350.seminar4.integration.DCHandler;
import se.kth.iv1350.seminar4.integration.EASHandler;
import se.kth.iv1350.seminar4.integration.EISHandler;
import se.kth.iv1350.seminar4.integration.Printer;
import se.kth.iv1350.seminar4.view.View;

/**
 * Starts the entire application. Contains the main method used to start the application.
 */
public class Main {
    /**
     * The main method used to start the application.
     * @param args The application does not take any command line parameters
    */
    public static void main(String[] args) {
        EASHandler eas = new EASHandler();
        EISHandler eis = new EISHandler();
        Printer printer = new Printer();
        DCHandler dc = new DCHandler();

        Controller contr = new Controller(eis, eas, printer, dc);
        View view = new View(contr);
        
        view.runFakeExecution();
    }
}
