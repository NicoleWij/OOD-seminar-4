package se.kth.iv1350.seminar4.controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.iv1350.seminar4.DTO.*;
import se.kth.iv1350.seminar4.integration.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ControllerTest {
    private Controller instance;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @Before
    public void setUp(){
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);

        EISHandler eis = new EISHandler();
        EASHandler eas = new EASHandler();
        DCHandler dc = new DCHandler();
        Printer printer = new Printer();

        instance = new Controller(eis, eas, printer, dc);
    }

    @After
    public void tearDown(){
        printoutBuffer = null;
        System.setOut(originalSysOut);

        instance = null;
    }


    @Test
    public void testUIHasStarted()
    {
        String printout = printoutBuffer.toString();
        String expectedOutput = "success";
        assertTrue("Controller did not start correctly.", printout.contains(expectedOutput));
    }


    @Test
    public void testStartSale(){
        instance.startSale();

        String printout = printoutBuffer.toString();
        String expectedOutput = "success";
        assertTrue("StartSale did not start correctly.", printout.contains(expectedOutput));
    }


    @Test
    public void testEnterItem(){

        instance.startSale();
        ItemDTO item = new ItemDTO("Nice red apple", 0, 0, null, "1identifier");
        try {
            SaleInfoDTO saleInfo = instance.enterItem(item.getIdentifier());
            assertEquals("Item was not identified", 
                item.getDescription(),
                saleInfo.getItemDescription()
            );
            
        } catch (Exception exc) {
            fail("An exception was thrown on a valid identifier:" + exc);
        }
    }


    @Test
    public void testPay(){
        double amountPaid = 100;
        instance.startSale();
        try {
            SaleInfoDTO saleInfo = instance.enterItem("1identifier");
            double price = saleInfo.getRunningTotal();
            double change = instance.pay(amountPaid, null);
    
            assertEquals("Change was not calculated correctly", 
                (amountPaid - price),
                change,
                0.01
            );
            
        } catch (Exception exc) {
            fail("An exception was thrown on a valid identifier:" + exc);
        }
    }
}