package gamedatas;

import items.Item;

public class GuardStorage
{
    /* ---------------------- START DECLARATIONS ---------------------- */
    
    /**
     * declaration of an array composed with Item objects.
     */
    Item[] storeItems;
    /**
     * declaration of an array composed with integers.
     */
    int[] storeCapacity;
    /* ---------------------- END DECLARATIONS ---------------------- */
    
    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    
    public void guardStorage()
    {
        this.storeItems = new Item[Store.NUMBER_OF_ITEMS_AVAILABLE];
        this.storeCapacity = new int[Store.NUMBER_OF_ITEMS_AVAILABLE];
    }
    
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */
    
    /* ---------------------- START FUNCTION(S) ---------------------- */
     
    /**
     * when a guard takes an item.
     *
     * @param item what the guards want for an item.
     * @param quantity how many items he wants to take.
     */
    
    public void takeItem(String item, Integer quantity)
    {
        this.storeCapacity[getPositionItemFromName(item)]-=quantity;
    }
    
     /**
     *
     * get the position in the array with the item name.
     *
     * @param itemName name of the item to search.
     * @return position of the item in the array.
     */
    
    public int getPositionItemFromName(String itemName)
    {
        int itemPosition = 0;
        String currentItemName = "";
        for (int i = 0; i < Store.NUMBER_OF_ITEMS_AVAILABLE && !currentItemName.equals(itemName); i++) {
            currentItemName = this.storeItems[i].getItemName();
            itemPosition = i;
        }
        return itemPosition;
    }
       
    /* ---------------------- END FUNCTION(S) ---------------------- */
    
    /* ---------------------- START GETTERS & SETTERS ---------------------- */
    
    public int[] getStoreCapacity()
    {
        return this.storeCapacity;
    }

    public Item[] getStoreItems()
    {
        return this.storeItems;
    }    
    
    /* ---------------------- END GETTERS AND SETTERS ---------------------- */    




}
