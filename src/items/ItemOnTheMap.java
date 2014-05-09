package items;

public class ItemOnTheMap extends Item
{

    /**
     * the x position of the item.
     */
    protected int posX;

    /**
     * the y position of the item.
     */
    protected int posY;

    protected boolean isOnMapYet = false;

    public ItemOnTheMap(String name, boolean spy, boolean guard, int time, int price, int posX, int posY)
    {
        super(name, spy, guard, time, price);
        this.posX = posX;
        this.posY = posY;
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

    public void putOnTheMap(int posX, int posY)
    {
        this.isOnMapYet = true;
        this.setXPos(posX);
        this.setYPos(posY);

    }

}
