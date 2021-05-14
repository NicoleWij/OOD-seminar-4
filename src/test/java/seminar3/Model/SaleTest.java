package seminar3.Model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import seminar3.DTO.*;
import seminar3.model.Receipt;
import seminar3.model.Sale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SaleTest {
    private Sale instance;

    @Before
    public void setUp(){
        instance = new Sale();
    }

    @After
    public void tearDown(){
        instance = null;
    }


    @Test
    public void testAddItem()
    {
        ItemDTO item = new ItemDTO(null, 0, 0, null, "Identifier");
        instance.addItem(item);

        assertEquals(
            "Item was not added.", 
            item.getIdentifier(), 
            instance.getItems().get(0).getIdentifier()
        );
    }


    @Test
    public void testUpdateRunningTotal()
    {
        double runningTotalBefore = instance.getTotalPrice();
        ItemDTO item = new ItemDTO(null, 0.2, 100, null, null);
        instance.addItem(item);

        assertEquals(
            "Running Total was not updated.", 
            (item.getPrice() + runningTotalBefore), 
            instance.getTotalPrice(),
            0.01
        );
    }


    @Test
    public void testCheckForDuplicate() {

        ItemDTO item = new ItemDTO(null, 0, 0, null, "1234");
        instance.addItem(item);
        
        assertEquals(
            "The function did not recognize the item as an already scanned item", 
            true, instance.checkForDuplicate(item.getIdentifier())
        );
    }

    @Test
    public void testAddDuplicate() {

        ItemDTO item = new ItemDTO(null, 0, 0, null, "1234");
        instance.addItem(item);
        int quantityBefore = instance.getItems().get(0).getQuantity();
        instance.duplicateIdentifier(item.getIdentifier());
        
        assertEquals(
            "The function did not recognize the item as an already scanned item", 
            quantityBefore + 1, instance.getItems().get(0).getQuantity()
        );
    }

    @Test
    public void testMakeSaleDTO() {
         instance.addItem(new ItemDTO("Test description", 1, 100, "Test", "1identifier"));
         instance.addItem(new ItemDTO("Test description", 1, 150, "Test", "2identifier"));
         SaleDTO convertInstance = instance.makeSaleDTO();
 
         assertEquals(
             "Sale was not converted to DTO successfully (Sizeof items)", 
             instance.getItems().size(), 
             convertInstance.getItems().size()
         );
 
         for(int i = 0; i < instance.getItems().size(); i++)
             assertTrue(
                 "Sale was not converted to DTO successfully (Items)",
                 instance.getItems().get(i).getIdentifier().equals(convertInstance.getItems().get(i).getIdentifier())
             );
 
         
         assertEquals("Sale was not converted to DTO successfully (totalPrice)", instance.getTotalPrice(), convertInstance.getTotalPrice(), .01);
         assertEquals("Sale was not converted to DTO successfully (totalVAT)", instance.getTotalVAT(), convertInstance.getTotalVAT(), .01);
    } 


    @Test
    public void testCompleteSale() {
         instance.addItem(new ItemDTO("Test item desciption", 1, 10, "Test", "Identifier1"));
         instance.addItem(new ItemDTO("Test item desciption", 1, 25, "Test", "Identifier2"));
 
         SaleDTO convertedInstance = instance.makeSaleDTO();
         PaymentDTO payment = new PaymentDTO(10, "SEK");
         Receipt receipt = instance.completeSale(convertedInstance, payment);
 
         assertEquals(
             "Receipt was not created successfully (Items) (Sizeof items)", 
             instance.getItems().size(), 
             convertedInstance.getItems().size()
         );
 
         for(int i = 0; i < instance.getItems().size(); i++)
             assertEquals(
                 "Receipt was not created successfully (Items)",
                 convertedInstance.getItems().get(i).getIdentifier(),
                 receipt.getItems().get(i).getIdentifier()
             );
 
         assertEquals("Receipt was not created successfully (Time)", convertedInstance.getTimeOfSale(), receipt.getTimeOfSale());
 
         assertEquals("Receipt was not created successfully (Price)", convertedInstance.getTotalPrice(), receipt.getTotalPrice(), .01);
         assertEquals("Receipt was not created successfully (VAT)", convertedInstance.getTotalVAT(), receipt.getTotalVAT(), .01);
         
         assertEquals("Receipt was not created successfully (Amount)", payment.getAmount(), receipt.getPaidAmount(), .01);
         assertEquals("Receipt was not created successfully (currency,)", payment.getCurrency(), receipt.getCurrency());
 
    } 
}
