package seminar3.integration;

import java.util.ArrayList;

import seminar3.DTO.*;

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
     * Finds the correct item from the external inventory system based on the items identifier
     * @param identifier
     * @return
     */
    public ItemDTO findItem(String identifier){
        for (ItemDTO item : items){
            if(item.getIdentifier().equals(identifier)) {
                return item;
            }
        }

        return null;
    }


    /**
     * This function updates the inventory based on what items were purchased
     * @param sale the completed sale
     */
    public void updateInventory(SaleDTO sale){
    }
}
