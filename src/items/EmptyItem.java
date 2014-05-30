package items;

import gamedatas.ClassicPlayer;

/**
 *
 * @author UCDP_Brony
 */
public class EmptyItem extends Item {

    private static final String EMPTY_ITEM_NAME = "EmptyItem";

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
     * Generates an empty item.
     */
    public EmptyItem()
    {
        super();
        this.itemName = EmptyItem.EMPTY_ITEM_NAME;
        this.itemPrice = EmptyItem.EMPTY_ITEM_PRICE;
        this.timeBeforeUnlock = EmptyItem.EMPTY_ITEM_UNLOCK_TIME;
        this.usableByAGuard = EmptyItem.EMPTY_ITEM_USABILITY;
        this.usableByASpy = EmptyItem.EMPTY_ITEM_USABILITY;
        this.posX = 0;
        this.posY = 0;
    }

    @Override
    public Item getNewItem()
    {
        return new EmptyItem();
    }

    @Override
    public void useItem(ClassicPlayer player)
    {
    }

}
