package items;

import gamedatas.ClassicPlayer;

/**
 *
 * Class used to represent an item.
 *
 * @author Woerly-Moussier Joachim <joachim.woerly-moussier@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 */
public abstract class Item
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

    /**
     * the x position of the item.
     */
    protected int posX;

    /**
     * the y position of the item.
     */
    protected int posY;

    protected boolean isOnMapYet = false;

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
        this.posX = 0;
        this.posY = 0;
    }

    public Item(String name, boolean spy, boolean guard, int time, int price, int posX, int posY)
    {
        this.itemName = name;
        this.itemPrice = price;
        this.timeBeforeUnlock = time;
        this.usableByAGuard = guard;
        this.usableByASpy = spy;
        this.posX = posX;
        this.posY = posY;
    }
    /* ---------------------- END CONSTRUCTOR(S) ---------------------- */

    /* ---------------------- START FUNCTION(S) ---------------------- */
    public void putOnTheMap(int posX, int posY)
    {
        this.isOnMapYet = true;
        this.setXPos(posX);
        this.setYPos(posY);

    }

    /**
     *
     * @param player
     */
    public abstract void useItem(ClassicPlayer player);

    /**
     *
     * @param player
     */
    public abstract void dropItem(ClassicPlayer player);

    /* ---------------------- END FUNCTION(S) ---------------------- */

    /* ---------------------- START GETTERS & SETTERS ---------------------- */
    /**
     * @return the itemName
     */
    public String getItemName()
    {
        return itemName;
    }

    /**
     * getter for the x pos.
     *
     * @return
     */
    public int getXPos()
    {
        return this.posX;
    }

    /**
     * getter for the y pos.
     *
     * @return
     */
    public int getYPos()
    {
        return this.posY;
    }

    /**
     * setter for the x pos.
     *
     * @param posX
     */
    public void setXPos(int posX)
    {
        this.posX = posX;
    }

    /**
     * setter for the y pos.
     *
     * @param posY
     */
    public void setYPos(int posY)
    {
        this.posY = posY;
    }
    /* ---------------------- END GETTERS AND SETTERS ---------------------- */

}
