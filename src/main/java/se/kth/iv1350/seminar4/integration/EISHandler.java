package se.kth.iv1350.seminar4.integration;

import java.util.ArrayList;

import se.kth.iv1350.seminar4.DTO.*;

/**
 * EISHandler, external inventory system handler. This class fetches data and writes to the inventory database.
 */
public class EISHandler {

    ArrayList<ItemDTO> items = new ArrayList<ItemDTO>();

    public EISHandler(){
        items.add(
            new ItemDTO("Nice red apple", 0.25, 10.0, "Svenskt äpple", "1identifier")
            );

        items.add(
            new ItemDTO("Liten potatis", 0.10, 20.0, "Fin potatis", "2identifer")
            );

        items.add(
            new ItemDTO("God gröt", 0.20, 15.0, "Gammelmormors gröt", "3identifer")
            );
    }
    
    /**
     * /**
     * Finds the correct item from the external inventory system based on the items identifier
     * @param identifier identifier of the item
     * @return returns the item with the same identifier
     * @throws ItemNotFoundException throws an exception if the item identifier is not found
     * @throws ServerDownException throws an exception if the server is down
     */
    public ItemDTO findItem(String identifier) throws ItemNotFoundException, ServerDownException {
        if(identifier.equals("ServerDownIdentifier")){
            throw new ServerDownException("Database cannot be called, server is down.");
        }

        for (ItemDTO item : items){
            if(item.getIdentifier().equals(identifier)) {
                return item;
            }
        }

        throw new ItemNotFoundException("No item found with the specified identifier: " + identifier);
    }


    /**
     * This function updates the inventory based on what items were purchased
     * @param sale the completed sale
     */
    public void updateInventory(SaleDTO sale){
    }
}
