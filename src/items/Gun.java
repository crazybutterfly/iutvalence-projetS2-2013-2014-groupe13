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
public class Gun extends Item
{

    private static final int NUMBER_MAX_OF_AMMO_IN_GUN = 6;
    private int numberOfAmmoOwned;
    private int numberOfAmmoInGun;

    @Override
    public void useItem(ClassicPlayer player)
    {
        if (this.numberOfAmmoInGun == 0) {
            System.out.println("no ammo");
        }
        else {
            this.numberOfAmmoInGun -= 1;
            // mouse.getPosX(), getPosY(); verify if character undermouse;
            //if distance < 1000px && noWalls=true, player.attack(the ennemy);
        }
    }

    public Gun()
    {
        super();
    }


    /**
     * reload the gun.
     */
    public void reload()
    {
        this.numberOfAmmoOwned -= this.numberOfAmmoInGun;
        this.numberOfAmmoInGun = 0;
        this.numberOfAmmoInGun += Gun.NUMBER_MAX_OF_AMMO_IN_GUN;
    }

    /**
     * getter for the number of ammunitions owned.
     *
     * @return the number of ammo owned by the player.
     */
    public int getNumberOfAmmoOwned()
    {
        return this.numberOfAmmoOwned;
    }

    /**
     * getter for the number of ammunitions in the gun.
     *
     * @return the number of ammo in the gun.
     */
    public int getNumberOfAmmoInGun()
    {
        return this.numberOfAmmoInGun;
    }

    @Override
    public Item getNewItem()
    {
        return new Gun();
    }
}
