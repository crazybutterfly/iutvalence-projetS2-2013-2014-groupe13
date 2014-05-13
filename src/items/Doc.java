/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import gamedatas.ClassicPlayer;

/**
 *
 * @author Woerly-Moussier Joachim <joachim.woerly-moussier@iut-valence.fr>
 */
public class Doc extends Item {

    private final static boolean CAN_SPIES_USE_DOC = true;
    private final static boolean CAN_GUARDS_USE_DOC = false;
    private final static int TIME_BEFORE_DOC_SPAWNS = 0;
    private final static int DOC_PRICE = 0;

    public Doc(int posX, int posY) {
        super("Doc", Doc.CAN_SPIES_USE_DOC, Doc.CAN_GUARDS_USE_DOC, Doc.TIME_BEFORE_DOC_SPAWNS, Doc.DOC_PRICE, posX, posY);
        this.isOnMapYet = true;
    }

    @Override
    public void useItem(ClassicPlayer player) {
    }

    @Override
    public void dropItem(ClassicPlayer player) {
        this.putOnTheMap(player.getPosX(), player.getPosY());
        this.isOnMapYet = true;
        player.removeItem(this.itemName);
    }

}
