/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import gamedatas.ClassicPlayer;
import gamedatas.Frame;
import gamedatas.Map;
import gamedatas.PlayerOrientation;

/**
 *
 * @author UCDP_Brony
 */
public class Gun extends Item {

    private static final int NUMBER_MAX_OF_AMMO_IN_GUN = 6;

    private int numberOfAmmoOwned;

    private int numberOfAmmoInGun;

    @Override
    public void useItem(ClassicPlayer player)
    {
        if (this.numberOfAmmoInGun == 0)
        {
            System.out.println("no ammo");
        }
        else
        {
            this.numberOfAmmoInGun -= 1;
            int bulletPosX = player.getPosX();
            int bulletPosY = player.getPosY();

            while ((player.getMap().getFrameStatus(bulletPosX, bulletPosY) != Frame.WALL) && ((bulletPosX < Map.MAX_X_SIZE && bulletPosX != 0) && (bulletPosY < Map.MAX_Y_SIZE && bulletPosY != 0)))
            {
                for (int index = 0; index < player.getPlayerArray().getNumberOfSpies(); index++)
                {
                    if ((player.getPlayerArray().getSpiesArray()[index].getPosX() == bulletPosX) && (player.getPlayerArray().getSpiesArray()[index].getPosY() == bulletPosY))
                    {
                        player.getPlayerArray().getSpiesArray()[index].playerHasBeenKilled();
                    }
                }
                if (player.getPlayerOrientation() == PlayerOrientation.UP)
                {
                    bulletPosY--;
                }
                if (player.getPlayerOrientation() == PlayerOrientation.LEFT)
                {
                    bulletPosX--;
                }
                if (player.getPlayerOrientation() == PlayerOrientation.DOWN)
                {
                    bulletPosY++;
                }
                if (player.getPlayerOrientation() == PlayerOrientation.RIGHT)
                {
                    bulletPosX++;
                }
            }
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
