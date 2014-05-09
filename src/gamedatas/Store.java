package gamedatas;

import items.Item;

/**
 * 
 * class Store is composed by two arrays : one is the list of all buyable items
 * and the other is the number of those items in the store. When players cant
 * buy them because ti's too early in the game or else, the number in the array
 * is 0.
 *
 * @author MITTOUX Hadrien <hadrien.mittoux@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 */
public abstract class Store
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

    /**
     * the number of availible items.
     */
    public final static int NUMBER_OF_ITEMS_AVAILABLE = 20;
    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public void Store()
    {
        this.storeItems = new Item[NUMBER_OF_ITEMS_AVAILABLE];
        this.storeCapacity = new int[NUMBER_OF_ITEMS_AVAILABLE];
    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */

    /**
     *
     * modificate the number of an item in the store.
     *
     * @param itemName name of the item you want to change.
     * @param modificator number of the modification.
     */
    public boolean changeStoreCapacity(String itemName, int modificator)
    {
        /**
         * A FINIR ----------------------------------------------------------
         */
        
//        if ((this.storeCapacity[this.getPositionItemFromName(itemName)] += modificator)<0){
//            this.storeCapacity[this.getPositionItemFromName(itemName)] += modificator;
//        }
        return true;
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
        for (int i = 0; i < NUMBER_OF_ITEMS_AVAILABLE && !currentItemName.equals(itemName); i++) {
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
