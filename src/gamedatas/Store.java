package gamedatas;

import items.EmptyItem;
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
public abstract class Store {

    /* ---------------------- START DECLARATIONS ---------------------- */
    /**
     * declaration of an array composed with Item objects.
     */
    Item[] storedItems;


    /**
     * the number of availible items.
     */
    public final static int NUMBER_OF_ITEMS_AVAILABLE = 20;

    /**
     * Default number of items by type in the store.
     */
    public final static int STORE_CAPACITY_DEFAULT = 0;

    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public void Store()
    {
        this.storedItems = new Item[Store.NUMBER_OF_ITEMS_AVAILABLE];
        for (int i = 0; i < Store.NUMBER_OF_ITEMS_AVAILABLE; i++)
        {
            this.storedItems[i] = new EmptyItem();
        }
    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    /**
     *
     * modificate the number of an item in the store.
     *
     * @param itemName    name of the item you want to change.
     * @param modificator number of the modification.
     * @return true if the change took place correctly, false otherwise.
     */
    public boolean changeStoreCapacity(String itemName, int modificator)
    {
        if ((this.storedItems[this.getPositionItemFromName(itemName)].getNumberOfItemsOfThisType() + modificator) > 0)
        {
            this.storedItems[this.getPositionItemFromName(itemName)].setNumberOfItemsOfThisType(this.storedItems[this.getPositionItemFromName(itemName)].getNumberOfItemsOfThisType() + modificator);
            return true;
        }
        else
        {
            if ((this.storedItems[this.getPositionItemFromName(itemName)].getNumberOfItemsOfThisType() + modificator) == 0)
            {
                this.storedItems[this.getPositionItemFromName(itemName)] = new EmptyItem();
                this.storedItems[this.getPositionItemFromName(itemName)].setNumberOfItemsOfThisType(1);
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    /**
     *
     * get the position in the array with the item name.
     *
     * @param itemName name of the item to search.
     *
     * @return position of the item in the array.
     */
    public int getPositionItemFromName(String itemName)
    {
        int itemPosition = 0;
        String currentItemName = "";
        for (int i = 0; i < Store.NUMBER_OF_ITEMS_AVAILABLE && !currentItemName.equals(itemName); i++)
        {
            currentItemName = this.storedItems[i].getItemName();
            itemPosition = i;
        }
        return itemPosition;
    }
    /* ---------------------- END FUNCTION(S) ---------------------- */

    /* ---------------------- START GETTERS & SETTERS ---------------------- */

    public Item[] getStoredItems()
    {
        return this.storedItems;
    }
    /* ---------------------- END GETTERS AND SETTERS ---------------------- */

}
