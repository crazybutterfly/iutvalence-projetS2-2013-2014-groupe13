package items;

import gamedatas.ClassicPlayer;

/**
 *
 * Class used to represent an item.
 *
 * @author Woerly-Moussier Joachim <joachim.woerly-moussier@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 */
public abstract class Item {

    /* ---------------------- START DECLARATIONS ---------------------- */
    protected String itemName;

    protected boolean usableByASpy;

    protected boolean usableByAGuard;

    protected int timeBeforeUnlock;

    protected int itemPrice;

    private int numberOfItemsOfThisType;


    /**
     * the x position of the item.
     */
    protected int posX;

    /**
     * the y position of the item.
     */
    protected int posY;

    public final static int DEFAULT_NUMBER_OF_ITEMS_OF_THIS_TYPE = 0;


    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
    public Item()
    {

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

    /**
     * @return the content of this item on the display button
     */
    public String buttonText()
    {
        String newToString = "";
        newToString += this.numberOfItemsOfThisType + " <" + this.itemName + ">";
        return newToString;
    }

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

    /**
     * @return the numberOfItemsOfThisType
     */
    public int getNumberOfItemsOfThisType()
    {
        return numberOfItemsOfThisType;
    }

    /**
     * @param numberOfItemsOfThisType the numberOfItemsOfThisType to set
     */
    public void setNumberOfItemsOfThisType(int numberOfItemsOfThisType)
    {
        this.numberOfItemsOfThisType = numberOfItemsOfThisType;
    }

    /**
     *
     * @param player
     */
    public abstract void useItem(ClassicPlayer player);


    /**
     *
     * @return
     */
    public abstract Item getNewItem();
    /* ---------------------- END GETTERS AND SETTERS ---------------------- */


}
