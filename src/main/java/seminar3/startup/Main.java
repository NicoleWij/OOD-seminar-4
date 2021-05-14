package seminar3.startup;

import seminar3.controller.Controller;
import seminar3.integration.EASHandler;
import seminar3.integration.EISHandler;
import seminar3.integration.Printer;
import seminar3.view.View;

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

        Controller contr = new Controller(eis, eas, printer);
        View view = new View(contr);
        
        view.runFakeExecution();
    }
}
