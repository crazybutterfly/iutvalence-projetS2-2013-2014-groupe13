package items;

/**
 *
 * Class used to represent an item.
 *
 * @author Woerly-Moussier Joachim <joachim.woerly-moussier@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 */
public class Item
{

    /* ---------------------- START DECLARATIONS ---------------------- */
    protected String itemName;

    protected boolean usableByASpy;

    protected boolean usableByAGuard;

    protected int timeBeforeUnlock;

    protected int itemPrice;

    /**
     * Name used for an Empty Item.
     */
    public final static String EMPTY_ITEM_NAME = "EmplyItem";

    /**
     * Usability by spies and guards for an Empty Item.
     */
    public final static boolean EMPTY_ITEM_USABILITY = false;

    /**
     * Time before unlock for an Empty item.
     */
    public final static int EMPTY_ITEM_UNLOCK_TIME = 0;

    /**
     * Price used of an Empty Item.
     */
    public final static int EMPTY_ITEM_PRICE = 0;

    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    /**
     * Generates an empty item.
     */
    public Item()
    {
        this.itemName = Item.EMPTY_ITEM_NAME;
        this.itemPrice = Item.EMPTY_ITEM_PRICE;
        this.timeBeforeUnlock = Item.EMPTY_ITEM_UNLOCK_TIME;
        this.usableByAGuard = Item.EMPTY_ITEM_USABILITY;
        this.usableByASpy = Item.EMPTY_ITEM_USABILITY;
    }

    public Item(String name, boolean spy, boolean guard, int time, int price)
    {
        this.itemName = name;
        this.itemPrice = price;
        this.timeBeforeUnlock = time;
        this.usableByAGuard = guard;
        this.usableByASpy = spy;
    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    /* ---------------------- END FUNCTION(S) ---------------------- */

    /* ---------------------- START GETTERS & SETTERS ---------------------- */
    /**
     * @return the itemName
     */
    public String getItemName()
    {
        return itemName;
    }

    public void useItem()
    {

    }
    /* ---------------------- END GETTERS AND SETTERS ---------------------- */

}
