package se.kth.iv1350.seminar4.view;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;

import se.kth.iv1350.seminar4.integration.*;
import se.kth.iv1350.seminar4.controller.Controller;


public class ViewTest {
    private View instanceToTest;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @Before
    public void setUp(){
        EISHandler eis = new EISHandler();
        EASHandler eas = new EASHandler();
        DCHandler dc = new DCHandler();
        Printer printer = new Printer();
        Controller contr = new Controller(eis, eas, printer, dc);
        instanceToTest = new View(contr);

        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }


    @After
    public void tearDown(){
        instanceToTest = null;

        printoutBuffer = null;
        System.setOut(originalSysOut);
    }


    @Test
    public void testRunFakeExecution()
    {
        instanceToTest.runFakeExecution();
        String printout = printoutBuffer.toString();
        String expectedOutput = "started";
        assertTrue("UI did not start correctly.", printout.contains(expectedOutput));
    }
}