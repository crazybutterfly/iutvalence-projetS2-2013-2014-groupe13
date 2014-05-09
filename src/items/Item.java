package items;

public class Item
{

    /* ---------------------- START DECLARATIONS ---------------------- */
    private String itemName;

    protected boolean usableByASpy;

    protected boolean usableByAGuard;

    protected int timeBeforeUnlock;

    protected int itemPrice;
    /* ---------------------- END DECLARATIONS ---------------------- */

    /* ---------------------- START CONSTRUCTOR(S) ---------------------- */
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
