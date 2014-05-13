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

    public EmptyItem()
    {
        super();
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
