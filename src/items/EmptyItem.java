/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import gamedatas.ClassicPlayer;

/**
 *
 * @author UCDP_Brony
 */
public class EmptyItem extends Item
{
    
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
    public void useItem(ClassicPlayer player)
    {
    }

    @Override
    public void dropItem(ClassicPlayer player)
    {
    }

}
