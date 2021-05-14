package se.kth.iv1350.seminar4.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.iv1350.seminar4.DTO.ItemDTO;

public class EISTest {
    private EISHandler instance;


    @Before
    public void setUp(){
        instance = new EISHandler();
    }


    @After
    public void tearDown(){
        instance = null;
    }


    @Test
    public void testFindItem()
    {
        ItemDTO item1 = new ItemDTO("Nice red apple", 0.25, 10.0, "Svenskt äpple", "1identifier");
        try{
            ItemDTO item2 = instance.findItem("1identifier");
            assertEquals("Item was not identified correctly", item1.getDescription(), item2.getDescription());
            assertEquals("Item was not identified correctly", item1.getVAT(), item2.getVAT(), 0.01);
            assertEquals("Item was not identified correctly", item1.getPrice(), item2.getPrice(), 0.01);
            assertEquals("Item was not identified correctly", item1.getName(), item2.getName());
            assertEquals("Item was not identified correctly", item1.getIdentifier(), item2.getIdentifier());
        }
        catch(Exception exc){
            fail("An exception was thrown on a valid identifier:" + exc);
        } 
    }

    @Test
    public void testFindItemWithInvalidIdentifier() {
        try {
            instance.findItem("Invalid identifier");
            fail("Exception was not thrown");

        } catch (ItemNotFoundException exc) {
            assertTrue("The exception message was wrong.", exc.getMessage().contains("No item found"));

        } catch (Exception exc) {
            fail("Wrong exception was thrown" + exc.getMessage());
        }
    }

    @Test
    public void testServerDownException() {
        try {
            instance.findItem("ServerDownIdentifier");
        } catch (ServerDownException exc) {
            assertTrue("The exception message was wrong.", exc.getMessage().contains("server is down"));
        } catch (Exception exc) {
            fail("Wrong exception was thrown" + exc.getMessage());
        }
    }
}
