package seminar3.Integration;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import seminar3.DTO.ItemDTO;
import seminar3.integration.*;

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
        ItemDTO item2 = instance.findItem("1identifier");
        assertEquals("Item was not identified correctly", item1.getDescription(), item2.getDescription());
        assertEquals("Item was not identified correctly", item1.getVAT(), item2.getVAT(), 0.01);
        assertEquals("Item was not identified correctly", item1.getPrice(), item2.getPrice(), 0.01);
        assertEquals("Item was not identified correctly", item1.getName(), item2.getName());
        assertEquals("Item was not identified correctly", item1.getIdentifier(), item2.getIdentifier());
    }
}
