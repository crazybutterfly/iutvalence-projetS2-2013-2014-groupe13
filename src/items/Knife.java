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
public class Knife extends Item{

    @Override
    public void useItem(ClassicPlayer player) {
        // mouse.getPosX(), getPosY(); verify if character undermouse;
        //if distance <10px, player.attack(the ennemy);
    }

    @Override
    public void dropItem(ClassicPlayer player) {
        this.putOnTheMap(player.getPosX(), player.getPosY());
        this.isOnMapYet = true;
        player.removeItem(this.itemName);
    }
    
}
