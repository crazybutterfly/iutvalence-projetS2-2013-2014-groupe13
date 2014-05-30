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
public class Material extends Item {

    @Override
    public void useItem(ClassicPlayer player)
    {
    }

    @Override
    public Item getNewItem()
    {
        return new Material();
    }

}
