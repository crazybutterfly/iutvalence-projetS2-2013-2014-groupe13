/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import gamedatas.ClassicPlayer;
import gamedatas.SpyPlayer;

/**
 *
 * @author UCDP_Brony
 */
public class Knife extends Item {

    public Knife()
    {
        super();
        this.itemName = "Knife";
    }

    @Override
    public void useItem(ClassicPlayer player)
    {
        for (int index = 0; index < player.getPlayerArray().getNumberOfGuards(); index++)
        {
            if ((player.getPlayerArray().getGuardsArray()[index].getPosX() == player.getPosX()) && (player.getPlayerArray().getGuardsArray()[index].getPosY() == player.getPosY()))
            {
                player.getPlayerArray().getGuardsArray()[index].playerHasBeenKilled();
            }
        }
    }

    @Override
    public Item getNewItem()
    {
        return new Knife();
    }

    @Override
    public void reload()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
