package gamedatas;


import items.Item;

public class GuardStorage
{

    /**
     * when a guard takes an item.
     *
     * @param item what the guards want for an item.
     * @param quantity how many items he wants to take.
     * @return an array containing the items the guard took.
     */
    public Item[] takeItem(Item item, Integer quantity)
    {
        Item[] itemArray;
        itemArray = new Item[quantity];
        return itemArray;
    }

}
